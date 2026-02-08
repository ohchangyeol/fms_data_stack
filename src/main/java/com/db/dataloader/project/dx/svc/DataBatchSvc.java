package com.db.dataloader.project.dx.svc;

import com.db.dataloader.project.dx.dto.TableInfoDto;
import com.db.dataloader.rsc.CommonConstant;
import com.db.dataloader.utils.TimeUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataBatchSvc {
    private final EntityManager em;
    private final TransactionTemplate txTemplate;

    public void process(TableInfoDto tableInfoDto) {
        List<Tuple> results = em.createNativeQuery(tableInfoDto.getSelect(), Tuple.class).getResultList();

        for (String partition : tableInfoDto.getPartitions()){
            txTemplate.execute(status -> {
                run(tableInfoDto, results, partition);
                return null;
            });
        }
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void run(TableInfoDto tableInfoDto, List<Tuple> results, String partition){
        LocalDateTime start = LocalDateTime.now();
        int totalCount = tableInfoDto.getMonthCnt();
        AtomicInteger totalInsertCount = new AtomicInteger();
        Iterator<LocalDateTime> dateIterator = splitMonthIterator(partition, totalCount);
        List<String> columns = resolveColumns(tableInfoDto);
        String insertSql = buildInsertSql(tableInfoDto, columns);

        int batchSize = tableInfoDto.getBatchSize() > 0 ? tableInfoDto.getBatchSize() : 1000;
        Random rng = new Random();

        Session session = em.unwrap(Session.class);
        session.doWork(conn -> {
            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                int count = 0;

                for (int i = 0; i < totalCount; i++) {
                    LocalDateTime ts = dateIterator.next();
                    Tuple t = results.get(rng.nextInt(results.size()));
                    int idx = 1;
                    for (String col : columns) {
                        String rule = tableInfoDto.getData().get(col);
                        idx = bindValue(ps, idx, rule, t, col, ts);
                    }
                    ps.addBatch();
                    count++;

                    boolean last = (i == totalCount - 1);
                    if (count == batchSize || last) {
                        ps.executeBatch();
                        totalInsertCount.addAndGet(count);
                        count = 0;
                        log.info("[{}] -insert count : {}",tableInfoDto.getTable(), totalInsertCount);
                    }
                }
            }
        });
        LocalDateTime end = LocalDateTime.now();

        log.info("[{}] -start time  : {} -end time : {} -time difference : {} -totalInsertCount count : {}",
                tableInfoDto.getTable(), start.format(CommonConstant.FORMATTER_TS), end.format(CommonConstant.FORMATTER_TS), TimeUtil.elapsedHms(start,end), totalInsertCount);
    }

    private List<String> resolveColumns(TableInfoDto config) {
        List<String> columns = new ArrayList<>();
        for (Map.Entry<String, String> entry : config.getData().entrySet()) {
            String rule = entry.getValue();
            if (!"auto".equalsIgnoreCase(rule)) {
                columns.add(entry.getKey());
            }
        }
        return columns;
    }

    private String buildInsertSql(TableInfoDto config, List<String> columns) {
        String verb = config.isIgnore() ? "INSERT IGNORE" : "INSERT";
        StringBuilder sb = new StringBuilder();
        sb.append(verb).append(" INTO ").append(config.getTable()).append("\n");
        sb.append("(").append(String.join(", ", columns)).append(")").append("\n");
        sb.append("VALUES (");
        for (int i = 0; i < columns.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append("?");
        }
        sb.append(")");
        return sb.toString();
    }

    private int bindValue(PreparedStatement ps, int index, String rule, Tuple t, String col, LocalDateTime ts)
            throws SQLException {
        if (rule == null || "none".equalsIgnoreCase(rule)) {
            setParam(ps, index, t.get(col));
            return index + 1;
        }
        switch (rule.toLowerCase(Locale.ROOT)) {
            case CommonConstant.COLUMN_TS:
                ps.setString(index, ts.format(CommonConstant.FORMATTER_TS));
                return index + 1;
            case CommonConstant.COLUMN_TS6:
                ps.setString(index, ts.format(CommonConstant.FORMATTER_TS6));
                return index + 1;
            case CommonConstant.COLUMN_DATE:
                ps.setString(index, ts.toLocalDate().format(CommonConstant.FORMATTER_DATE));
                return index + 1;
            case CommonConstant.COLUMN_YMDHMS:
                ps.setString(index, ts.format(CommonConstant.FORMATTER_YMDHMS));
                return index + 1;
            case CommonConstant.COLUMN_YMD:
                ps.setString(index, ts.toLocalDate().format(CommonConstant.FORMATTER_YMD));
                return index + 1;
            case CommonConstant.COLUMN_AUTO:
                return index;
            default:
                throw new IllegalArgumentException("Unknown rule: " + rule + " for column " + col);
        }
    }

    private void setParam(PreparedStatement ps, int index, Object value) throws SQLException {
        if (value == null) {
            ps.setNull(index, Types.VARCHAR);
            return;
        }
        ps.setObject(index, value);
    }

    private Iterator<LocalDateTime> splitMonthIterator(String yearMonth, int totalCount) {
        int year = Integer.parseInt(yearMonth.substring(0, 4));
        int month = Integer.parseInt(yearMonth.substring(5, 7));

        LocalDate startDate = LocalDate.of(year, month, 1);
        int daysInMonth = startDate.lengthOfMonth();
        long totalSeconds = daysInMonth * 24L * 60L * 60L;
        long totalNanos = totalSeconds * 1_000_000_000L;
        long base = totalNanos / totalCount;
        long remainder = totalNanos % totalCount;

        LocalDateTime start = startDate.atStartOfDay();

        return new Iterator<>() {
            private long index = 0;

            @Override
            public boolean hasNext() {
                return index < totalCount;
            }

            @Override
            public LocalDateTime next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                long offset = (index * base) + Math.min(index, remainder);
                LocalDateTime timestamp = start.plusNanos(offset);
                index++;
                return timestamp;
            }
        };
    }
}
