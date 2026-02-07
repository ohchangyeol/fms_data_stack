package com.db.dataloader.repository;

import com.db.dataloader.fms.dto.TableColumnDetail;
import com.db.dataloader.fms.dto.TableCountResult;
import com.db.dataloader.fms.dto.TablePartition;
import com.db.dataloader.fms.dto.TablePartitionDetail;
import com.db.dataloader.fms.repository.TableNativeRepository;
import com.db.dataloader.fms.resource.CommonConstant;
import com.db.dataloader.fms.resource.SqlConstant;
import com.db.dataloader.fms.service.DataCreateSvc;
import com.db.dataloader.fms.utils.CommonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.sql.Timestamp;
import java.util.*;

@Slf4j
@SpringBootTest
@ActiveProfiles("local")
class TableNativeRepositoryTest {

    @Autowired
    private TableNativeRepository tableNativeRepository;
    @Autowired
    private Environment environment;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DataCreateSvc dataCreateSvc;


    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("sm.mysql.password", () -> "doqjzjtm1!");
    }

    @Test
    @DisplayName("Table Count")
    public void getTableCountResults(){
        System.out.println("Count Table Start");
        List<TableCountResult> tableCountResults = tableNativeRepository.getTableCountResults();
        System.out.println("Count Table End \n result : \n"+ tableCountResults);
    }

    @Test
    @DisplayName("Table Column Details")
    public void getTableColumn(){
        System.out.println("Table Details Start");
        String schema = CommonConstant.SCHEMA_UFMSNEW;
        String table = "TB_BANNER_INFORMATION";
        List<TableColumnDetail> tableColumns = tableNativeRepository.getTableColumn("TableNative.sql", "findColumnDetails", schema, table);
        System.out.println("Table Details End \n result : \n"+ tableColumns);
    }


    @Test
    @DisplayName("findPartitionTable")
    public void findPartitionTable() throws JsonProcessingException {
        String schema = CommonConstant.SCHEMA_UFMSNEW;
        String table = "tb_geo_fencing_alarm_histories";
        List<TablePartition> partitionTable = tableNativeRepository.getPartitionTable("TableNative.sql", "findPartitionTable");

        System.out.println(partitionTable.toString());
    }

    @Test
    @DisplayName("getPartitionCount")
    public void getPartitionCount() throws JsonProcessingException {

        List<TablePartitionDetail> partitionCount = tableNativeRepository.getPartitionCount("TableNative.sql", "findPartitionCount", "initufmsnew", "tb_geo_fencing_alarm_histories");

        System.out.println(partitionCount.toString());
    }

    @Test
    @DisplayName("getPartitionTest")
    public void getPartitionTest() throws JsonProcessingException {
        String schema = CommonConstant.SCHEMA_UFMSNEW;
        String table = "tb_geo_fencing_alarm_histories";

        List<TablePartition> partitionTable = tableNativeRepository.getPartitionTable("TableNative.sql", "findPartitionTable");
        List<TableColumnDetail> tableColumns = tableNativeRepository.getTableColumn("TableNative.sql", "findColumnDetails", schema, table);

        boolean exists = partitionTable.stream()
                .anyMatch(p -> p.getTableSchema().equalsIgnoreCase(schema) && p.getTableName().equalsIgnoreCase(table));

        List<TablePartitionDetail> partitionCount = new ArrayList<>();
        if(exists){
            partitionCount = tableNativeRepository.getPartitionCount("TableNative.sql", "findPartitionCount", schema, table);
        }


        System.out.println(partitionCount.toString());
    }

    @Test
    @DisplayName("createPartitionDifferenceCount")
    public void createPartitionDifferenceCount(){
        /*
        List<TablePartition> partitionTable = tableNativeRepository.getPartitionTable("TableNative.sql", "findPartitionTable");

        TableDefinition[] allTables = TableDefinition.values();
        for (TableDefinition table : allTables) {
            boolean isPartition = partitionTable.stream()
                    .anyMatch(p -> p.getTableSchema().equalsIgnoreCase(table.getSchema()) && p.getTableName().equalsIgnoreCase(table.name()));

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
            }
            System.out.println("finishPartitionCountList" + finishPartitionCountList.toString());
        }
        */
    }



    @Test
    @DisplayName("Create Table Insert SQL")
    public void createInsertSql() throws JsonProcessingException {
        System.out.println("Table Details Start");
        String schema = CommonConstant.SCHEMA_UFMSNEW;
        String table = "TB_SMS_SENDING_GROUP";
        List<TableColumnDetail> tableColumns = tableNativeRepository.getTableColumn("TableNative.sql", "findColumnDetails", schema, table);

        // JPA 미사용
        // Class<?> entityBySchemaAndTable = CommonUtils.findEntityBySchemaAndTable(schema, table);
        // System.out.println(entityBySchemaAndTable.getClass().getName());
        // Object o = null;
        // try {
        //     o = entityBySchemaAndTable.getDeclaredConstructor().newInstance();
        // }catch (Exception e) {
        //     throw new RuntimeException("class Instance 생성 오류 : " + entityBySchemaAndTable.getClass().getName(), e);
        // }
        Integer startIdx = environment.getProperty("db-table.startIdx", Integer.class);
        List<String> columnNameList = tableColumns.stream().map(TableColumnDetail::getColumnName).toList();
        // List<StringBuilder> columnValueList = new LinkedList<>();
        List<List<Object>> columnValueList = new LinkedList<>();

        int differenceCount = 1000;

        for (int i = 0; i < differenceCount; i++) {
            LinkedList<Object> colunms = new LinkedList<>();


            for (int j = 0; j < tableColumns.size(); j++) {
                TableColumnDetail detail = tableColumns.get(j);

                Object value = "NO".equals(detail.getIsNullable()) ? CommonUtils.setFieldValue(detail, startIdx , new Timestamp(System.currentTimeMillis())) : CommonUtils.setFixValue(detail,null);
                colunms.add(value);

            }
            columnValueList.add(colunms);
            startIdx++;

        }

        if(columnValueList.size() != 0){
            List<String> placeholders = columnNameList.stream()
                    .map(col -> col.equalsIgnoreCase("poi") ? "ST_GeomFromText(?)" : "?")
                    .toList();

            String insertSql = String.format(
                    SqlConstant.INSERT_SQL,
                    schema, table,
                    String.join(", ", columnNameList),
                    String.join(", ", placeholders)
            );

            System.out.println("insert SQL : \n " + insertSql);

            tableNativeRepository.save(insertSql,columnValueList);
        }else {
            System.out.println("insert value size : 0 !!!!");
        }
    }

    @Test
    @DisplayName("Full Insert SQL")
    public void fullTest() throws JsonProcessingException {
        dataCreateSvc.dataCreateAll();
        // System.out.println("STEP 1 : 테이블 카운트 조회");
        // List<TableCountResult> tableCountResults = tableNativeRepository.getTableCountResults();
        //
        // System.out.println("STEP 2 : 테이블 컬럼 상세 조회");
        // int index = 1 ;
        // for (TableCountResult tableCountResult :tableCountResults){
        //     if(!tableCountResult.isMatchStatus()){
        //         System.out.println("STEP 2 - "+index+" - 1 : 데이터 세팅 시작" );
        //
        //         List<TableColumnDetail> tableColumns = tableNativeRepository.getTableColumn("TableNative.sql", "findColumnDetails", tableCountResult.getTableSchema(), tableCountResult.getTableName());
        //
        //         Integer startIdx = environment.getProperty("db-table.startIdx", Integer.class);
        //         List<String> columnNameList = tableColumns.stream().map(TableColumnDetail::getColumnName).toList();
        //
        //         // int differenceCount = tableCountResult.getDifferenceCount();
        //         int differenceCount = Math.min(tableCountResult.getDifferenceCount(), 1000); // test용도로 100개 이상시 100개로 세팅함
        //         List<List<Object>> columnValueList = new LinkedList<>();
        //
        //         for (int i = 0; i < differenceCount; i++) {
        //             LinkedList<Object> colunms = new LinkedList<>();
        //             for (int j = 0; j < tableColumns.size(); j++) {
        //                 TableColumnDetail detail = tableColumns.get(j);
        //
        //                 Object value = "NO".equals(detail.getIsNullable()) ? CommonUtils.setFieldValue(detail, startIdx) : CommonUtils.setFixValue(detail,null);
        //                 colunms.add(value);
        //
        //             }
        //             columnValueList.add(colunms);
        //             startIdx++;
        //
        //         }
        //         List<String> placeholders = columnNameList.stream()
        //                 .map(col -> col.equalsIgnoreCase("poi") ? "ST_GeomFromText(?)" : "?")
        //                 .toList();
        //
        //         String insertSql = String.format(
        //                 SqlConstant.INSERT_SQL,
        //                 tableCountResult.getTableSchema(), tableCountResult.getTableName(),
        //                 String.join(", ", columnNameList),
        //                 String.join(", ", placeholders)
        //         );
        //
        //         System.out.println("STEP 2 - "+index+" - 2 : " + tableCountResult.getTableSchema()+"."+tableCountResult.getTableName() + " 테이블 insert " );
        //         tableNativeRepository.save(insertSql,columnValueList);
        //         index++;
        //     }
        // }



    }


}