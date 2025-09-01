package com.db.initalizr.service;

import com.db.initalizr.dto.TableColumnDetail;
import com.db.initalizr.dto.TableCountResult;
import com.db.initalizr.dto.TablePartition;
import com.db.initalizr.dto.TablePartitionDetail;
import com.db.initalizr.repository.TableNativeRepository;
import com.db.initalizr.resource.SqlConstant;
import com.db.initalizr.resource.TableDefinition;
import com.db.initalizr.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DataCreateSvc {
    private final  TableNativeRepository tableNativeRepository;
    private final Environment environment;

    public void dataCreateAll() {
        log.info("STEP 1 : 테이블 카운트 조회");
        List<TableCountResult> tableCountResults = tableNativeRepository.getTableCountResults();

        log.info("STEP 2 : 테이블 컬럼 상세 조회");
        int index = 1 ;
        List<TablePartition> partitionTable = tableNativeRepository.getPartitionTable("TableNative.sql", "findPartitionTable");

        for (TableCountResult tableCountResult :tableCountResults){
            if(!tableCountResult.isMatchStatus()){

                TableDefinition tableInfo = TableDefinition.findByNameAndSchema(tableCountResult.getTableSchema(), tableCountResult.getTableName());
                if(ObjectUtils.isEmpty(tableInfo)){
                    log.error("STEP 2 : TableDefinition 조회 실패 : {}.{}", tableCountResult.getTableSchema(),tableCountResult.getTableName());
                    continue;
                }

                boolean isPartition = partitionTable.stream()
                        .anyMatch(p -> p.getTableSchema().equalsIgnoreCase(tableInfo.getSchema()) && p.getTableName().equalsIgnoreCase(tableInfo.name()));
                log.info("STEP 2 - "+index+" - 1 : 월별 필요 건수 조회" );
                List<TablePartitionDetail> partitionDifferenceCount = this.createPartitionDifferenceCount(tableInfo, isPartition , tableCountResult.getDifferenceCount());

                log.info("STEP 2 - "+index+" - 2 : 데이터 세팅 시작" );
                List<TableColumnDetail> tableColumns = tableNativeRepository.getTableColumn("TableNative.sql", "findColumnDetails", tableCountResult.getTableSchema(), tableCountResult.getTableName());

                Integer startIdx = environment.getProperty("db-table.startIdx", Integer.class);
                List<String> columnNameList = tableColumns.stream().map(TableColumnDetail::getColumnName).toList();

                List<List<Object>> columnValueList = new LinkedList<>();

                for (TablePartitionDetail tablePartitionDetail : partitionDifferenceCount) {

                    Timestamp ts = getStringToTimestamp(tablePartitionDetail);
                    long intervalSeconds = getMonthSeconds(tablePartitionDetail, tablePartitionDetail.getTableRows());

                    if(tablePartitionDetail.getTableRows() > 0 ){

                        for (int i = 0; i < tablePartitionDetail.getTableRows(); i++) {
                            LinkedList<Object> colunms = new LinkedList<>();

                            for (TableColumnDetail detail : tableColumns) {
                                Object value = "NO".equals(detail.getIsNullable()) ?
                                        CommonUtils.setFieldValue(detail, startIdx, ts) : CommonUtils.setFixValue(detail, null);
                                colunms.add(value);

                            }
                            columnValueList.add(colunms);
                            startIdx++;
                            ts = new Timestamp(ts.getTime() + intervalSeconds * 1000);
                        }

                    }
                }

                List<String> placeholders = columnNameList.stream()
                        .map(col -> col.equalsIgnoreCase("poi") ? "ST_GeomFromText(?)" : "?")
                        .toList();

                String insertSql = String.format(
                        SqlConstant.INSERT_SQL,
                        tableCountResult.getTableSchema(), tableCountResult.getTableName(),
                        String.join(", ", columnNameList),
                        String.join(", ", placeholders)
                );

                log.info("STEP 2 - "+index+" - 2 : " + tableCountResult.getTableSchema()+"."+tableCountResult.getTableName() + " 테이블 insert start" );
                tableNativeRepository.save(insertSql,columnValueList);
                index++;
            }
        }



    }

    private Timestamp getStringToTimestamp(TablePartitionDetail tablePartitionDetail) {
        YearMonth ym = YearMonth.parse(tablePartitionDetail.getYearMonth(), DateTimeFormatter.ofPattern("yyyyMM"));
        LocalDateTime startOfMonth = ym.atDay(1).atStartOfDay();
         return  Timestamp.valueOf(startOfMonth);
    }

    private long getMonthSeconds(TablePartitionDetail tablePartitionDetail, long count) {
        YearMonth ym = YearMonth.parse(tablePartitionDetail.getYearMonth(), DateTimeFormatter.ofPattern("yyyyMM"));
        LocalDateTime start = ym.atDay(1).atStartOfDay();
        LocalDateTime end = ym.plusMonths(1).atDay(1).atStartOfDay(); // exclusive

        long seconds = Duration.between(start, end).getSeconds();
        return  seconds / count;
    }
    private List<TablePartitionDetail> createPartitionDifferenceCount(TableDefinition table ,boolean isPartition ,int differenceCount)  {

        List<TablePartitionDetail> finishPartitionCountList = getFinishPartitionCountList(table);
        if(isPartition){
            List<TablePartitionDetail> currentPartitionCountList = tableNativeRepository.getPartitionCount("TableNative.sql", "findPartitionCount", table.getSchema(), table.name());
            for (TablePartitionDetail tableCountDetail  :finishPartitionCountList){

                TablePartitionDetail tablePartitionDetail = currentPartitionCountList.stream()
                        .filter(obj -> obj.getPartitionName().equals(tableCountDetail.getPartitionName()))
                        .findFirst()
                        .orElseGet(() -> null);

                if(!ObjectUtils.isEmpty(tablePartitionDetail)){
                    tableCountDetail.setTableRows(tableCountDetail.getTableRows() - tablePartitionDetail.getTableRows());
                }

            }
            // long totalSeconds = Duration.between(startDate, endDate).getSeconds();
        }else{
            for (TablePartitionDetail tableCountDetail  :finishPartitionCountList){
                double temp =  (double)(differenceCount ) / finishPartitionCountList.size();
                int differenceMonth = (int) Math.ceil(temp);   // 올림
                tableCountDetail.setTableRows(differenceMonth);
            }

        }
        return finishPartitionCountList;
    }

    private List<TablePartitionDetail> getFinishPartitionCountList(TableDefinition table) {
        List<TablePartitionDetail> finishPartitionCountList = new LinkedList<>();

        LocalDateTime firstDayOfMonth = LocalDateTime.now().withDayOfMonth(1).with(LocalTime.MIN);
        LocalDateTime startDate = firstDayOfMonth.minusMonths(table.getStorageDuration());
        for (int i = 0; i <= table.getStorageDuration(); i++) {
            LocalDateTime partitionDate = startDate.plusMonths(i);
            String yyyyMM = partitionDate.format(DateTimeFormatter.ofPattern("yyyyMM"));

            finishPartitionCountList.add(new TablePartitionDetail(table.getSchema() , table.name(), "p"+yyyyMM, table.getIncreaseMonth() , yyyyMM));
        }
        return finishPartitionCountList;
    }
}
