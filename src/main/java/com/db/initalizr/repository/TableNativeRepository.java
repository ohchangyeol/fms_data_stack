package com.db.initalizr.repository;

import com.db.initalizr.dto.TableColumnDetail;
import com.db.initalizr.dto.TableCountResult;
import com.db.initalizr.dto.TablePartition;
import com.db.initalizr.dto.TablePartitionDetail;
import com.db.initalizr.resource.CommonConstant;
import com.db.initalizr.resource.SqlConstant;
import com.db.initalizr.resource.TableDefinition;
import com.db.initalizr.utils.CommonUtils;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Repository
@RequiredArgsConstructor
public class TableNativeRepository {

    private final EntityManager em;
    private final JdbcTemplate jdbcTemplate;
    private final ResourceLoader resourceLoader;
    private final Environment environment;

    public List<TableCountResult> getTableCountResults() {
        // count SQL 시작
        StringBuilder sql = new StringBuilder(SqlConstant.COUNT_START_SQL);
        // 테이블 설정 조회
        TableDefinition[] allTables = TableDefinition.values();

        // table size 설정
        int index = 0, lastIndex = allTables.length - 1;

        // Subquery 생성
        for (TableDefinition table : allTables) {
            String tableFullName = String.format(CommonConstant.TABLE_NAME, table.getSchema(),table.name());
            String union = (index < lastIndex) ? CommonConstant.UNION_ALL : "";

            String selectTable = String.format(SqlConstant.COUNT_MAIN_SQL,
                    table.getSchema(),
                    table.name(),
                    tableFullName,
                    table.getBaseCount(),
                    tableFullName,
                    union
            );
            index++;
            sql.append(selectTable);
        }
        // count SQL 끝
        sql.append(SqlConstant.COUNT_END_SQL);

        List<Object[]> results = em.createNativeQuery(sql.toString()).getResultList();

        return results.stream()
                .map(r -> new TableCountResult(
                        (String) r[0],
                        (String) r[1],
                        (String) r[2],
                        ((Number) r[3]).intValue(),
                        ((Number) r[4]).intValue(),
                        ((Number) r[5]).intValue(),
                        Boolean.parseBoolean((String) r[6])
                ))
                .toList();
    }

    public List<TableColumnDetail> getTableColumn(String fileName, String queryName, String schema, String tableName) {
        String sql = loadQuery(fileName, queryName);
        List<Object[]> results = em.createNativeQuery(sql)
                .setParameter("schema", schema)
                .setParameter("table", tableName)
                .getResultList();
        return results.stream()
                .map(r -> new TableColumnDetail(
                        (String) r[0],
                        (String) r[1],
                        (String) r[2],
                        (String) r[3],
                        r[4] != null ? ((Number) r[4]).intValue() : 0,
                        (String) r[5],
                        (String) r[6],
                        (String) r[7],
                        (String) r[8],
                        (String) r[9]
                ))
                .toList();
    }

    public List<TablePartition> getPartitionTable(String fileName, String queryName) {
        String sql = loadQuery(fileName, queryName);
        List<Object[]> results = em.createNativeQuery(sql)
                // .setParameter("schema", schema)
                // .setParameter("table", tableName)
                .getResultList();
        return results.stream()
                .map(r -> new TablePartition(
                        (String) r[0],
                        (String) r[1],
                        (String) r[2]
                ))
                .toList();
    }

    public List<TablePartitionDetail> getPartitionCount(String fileName, String queryName, String schema, String tableName) {
        String sql = loadQuery(fileName, queryName);
        List<Object[]> results = em.createNativeQuery(sql)
                .setParameter("schema", schema)
                .setParameter("table", tableName)
                .getResultList();
        return results.stream()
                .map(r -> new TablePartitionDetail(
                        (String) r[0],
                        (String) r[1],
                        (String) r[2],
                        r[3] != null ? ((Number) r[3]).intValue() : 0,
                        (String) r[4]
                ))
                .toList();
    }
    @Transactional
    public void save(String sql,List<List<Object>> valueList) {
        int chunkSize = environment.getProperty("db-table.batch-size", Integer.class);

        if(CollectionUtils.isEmpty(valueList)){
            log.error("Insert size : 0");
        }
        try {
            int total = valueList.size();
            int processed = 0;

            for (int i = 0; i < valueList.size(); i += chunkSize) {
                List<List<Object>> subList = valueList.subList(i, Math.min(i + chunkSize, valueList.size()));
                jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int idx) throws SQLException {
                        List<Object> row = subList.get(idx);
                        for (int j = 0; j < row.size(); j++) {
                            ps.setObject(j + 1, row.get(j));
                        }
                    }
                    @Override
                    public int getBatchSize() {
                        return subList.size();
                    }
                });
                processed += subList.size();
                log.info("Progress: {}/{} ({}%)", processed, total, (processed * 100 / total));
            }

        } catch (DataAccessException e) {
            Throwable cause = e.getCause();

            if (cause instanceof BatchUpdateException batchEx) {
                int[] updateCounts = batchEx.getUpdateCounts();

                for (int i = 0; i < updateCounts.length; i++) {
                    if (updateCounts[i] == Statement.EXECUTE_FAILED) {
                        List<Object> failedRow = valueList.get(i);
                        // log.error("Fail Row: {}", failedRow);
                    }
                }
                log.error("Insert 실패 사유: {}", batchEx.getMessage());
            } else {
                log.error("DB 오류 발생", e);
            }
        }
    }

    public String loadQuery(String fileName,String queryName) {

        try (InputStream is = resourceLoader.getResource("classpath:sql/" + fileName).getInputStream()) {
            String allQueries = new String(is.readAllBytes(), StandardCharsets.UTF_8);
            Pattern pattern = Pattern.compile("--\\s*name:\\s*" + Pattern.quote(queryName) + "\\s*(.*?)(;\\s*|$)", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(allQueries);
            if (matcher.find()) {
                return matcher.group(1).trim();
            } else {
                throw new IllegalArgumentException("쿼리 [" + queryName + "] 를 찾을 수 없습니다.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}