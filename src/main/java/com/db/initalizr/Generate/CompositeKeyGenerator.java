package com.db.initalizr.Generate;

import ch.qos.logback.core.util.StringUtil;
import com.db.initalizr.resource.CommonConstant;

import java.io.FileWriter;
import java.sql.*;
import java.util.*;

/**
 * 테이블 -> DTO 생성
 */
public class CompositeKeyGenerator {

    private static final String DB_URL = "jdbc:mysql://uconnect.conv.site:33062?autoReconnect=true&characterEncoding=UTF-8&serverTimezone=Asia/Seoul&allowMultiQueries=true";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "doqjzjtm1!";

    private static final String BASE_PATH = System.getProperty("user.dir")+"/src/main/java/"; // 현재 프로젝트 루트
    private static final String ENTITY_CLASS_PACKAGE = "com.db.initalizr.entity";
    // private static final String ENTITY_CLASS_PACKAGE = "com.db.initalizr.test";

    private static final String ID_CLASS_PACKAGE = ENTITY_CLASS_PACKAGE + ".pk";


    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            DatabaseMetaData metaData = conn.getMetaData();

            String[] schemas = {CommonConstant.SCHEMA_UFMSNEW, CommonConstant.SCHEMA_UFMSLOG, CommonConstant.SCHEMA_UFMSWD};
            for (String schema : schemas) {

                ResultSet tables = metaData.getTables(schema, null, "%", new String[]{"TABLE"});
                while (tables.next()) {
                    String tableName = tables.getString("TABLE_NAME");
                    List<Map> pkColumns = getPrimaryKeys(metaData, schema, tableName);
                    List<Map> nonPkColumns = getNonPrimaryKeys(metaData, schema, tableName);

                    System.out.println("Generating for table: " + schema+"."+tableName);

                    String className = toPascalCase(tableName);
                    String idClassName = null;

                    // 복합키 class 생성
                    if (pkColumns.size() > 1) {
                        idClassName = className + "Id";
                        generateIdClass(idClassName, pkColumns);
                    }

                    generateEntityClass(tableName, schema, className, idClassName, pkColumns, nonPkColumns);
                }
            }

        }
    }

    private static List<Map> getPrimaryKeys(DatabaseMetaData metaData, String catalog, String tableName) throws SQLException {
        ResultSet pk = metaData.getPrimaryKeys(catalog, null, tableName);
        List<Map> pkColumns = new ArrayList<>();
        while (pk.next()) {
            String columnName = pk.getString(CommonConstant.COLUMN_NAME);
            // 순서 유지
            Map<String, Object> pkColumn = new LinkedHashMap<>();
            // 컬럼 타입 조회
            ResultSet columns = metaData.getColumns(null, null, tableName, columnName);
            if (columns.next()) {
                String columnType = columns.getString(CommonConstant.COLUMN_TYPE);
                String isAutoIncrement = columns.getString(CommonConstant.IS_AUTOINCREMENT); // YES, NO, or null

                pkColumn.put(CommonConstant.COLUMN_NAME, columnName);
                pkColumn.put(CommonConstant.COLUMN_TYPE, toDataType(columnType));
                pkColumn.put(CommonConstant.IS_AUTOINCREMENT, "YES".equalsIgnoreCase(isAutoIncrement) );
                // pkColumn.put(columnName, toDataType(columnType));
            }
            pkColumns.add(pkColumn);

            columns.close();
        }
        pk.close();
        return pkColumns;
    }

    private static List<Map> getNonPrimaryKeys(DatabaseMetaData metaData, String catalog, String tableName) throws SQLException {
        // Step 1: PK 컬럼 모음
        Set<String> pkColumns = new HashSet<>();
        ResultSet pk = metaData.getPrimaryKeys(catalog, null, tableName);
        while (pk.next()) {
            pkColumns.add(pk.getString(CommonConstant.COLUMN_NAME));
        }
        pk.close();

        // Step 2: 모든 컬럼 중 PK 제외
        List<Map> nonPkColumns = new ArrayList<>();
        ResultSet columns = metaData.getColumns(catalog, null, tableName, "%");

        while (columns.next()) {
            String columnName = columns.getString(CommonConstant.COLUMN_NAME);
            if (!pkColumns.contains(columnName)) {
                // 순서 유지
                Map<String, String> column = new LinkedHashMap<>();
                String columnType = columns.getString(CommonConstant.COLUMN_TYPE);

                column.put(CommonConstant.COLUMN_NAME, columnName);
                column.put(CommonConstant.COLUMN_TYPE, toDataType(columnType));

                // column.put(columnName, toDataType(columnType));
                nonPkColumns.add(column);
            }
        }
        columns.close();

        return nonPkColumns;
    }

    // 미구현
    private static void generateIdClass(String idClassName, List<Map> pkColumns) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(ID_CLASS_PACKAGE).append(";\n\n")
                .append("import lombok.*;\n\n")
                .append("import java.io.Serializable;\n")
                .append("import java.sql.*;\n\n")
                .append("@Data\n")
                .append("@NoArgsConstructor\n")
                .append("@AllArgsConstructor\n")
                // .append("@Embeddable\n")
                .append("public class ").append(idClassName).append(" implements Serializable {\n");

        for (Map col : pkColumns) {
            sb.append("    private ").append(col.get(CommonConstant.COLUMN_TYPE)).append(" ").append(col.get(CommonConstant.COLUMN_NAME)).append(";\n");
        }
        sb.append("}\n");

        String filePath = BASE_PATH + ID_CLASS_PACKAGE.replace(".", "/") +"/" + idClassName + ".java";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(sb.toString());
        }
    }

    private static void generateEntityClass(String tableName, String schema , String className, String idClassName, List<Map> pkColumns, List<Map> nonPkColumns) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("package ").append(ENTITY_CLASS_PACKAGE).append(";\n\n")
                .append("import jakarta.persistence.*;\n")
                .append("import java.sql.*;\n\n");

        if (StringUtil.notNullNorEmpty(idClassName)){
            sb.append("import " + ID_CLASS_PACKAGE + "." + idClassName +";\n\n");
            sb.append("@IdClass(").append(idClassName).append(".class)\n");
        }

        sb.append("@Entity\n")
            .append("@Table(")
            .append(" schema = \"").append(schema).append("\",")
            .append(" name = \"").append(tableName).append("\")\n")
            .append("public class ").append(className).append(" {\n");

        for (Map col : pkColumns) {
            String accessModifier = (boolean)col.get(CommonConstant.IS_AUTOINCREMENT) ?
                    "    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) \n    private " : "    @Id private ";
            sb.append(accessModifier).append(col.get(CommonConstant.COLUMN_TYPE)).append(" ").append(col.get(CommonConstant.COLUMN_NAME)).append(";\n");
        }
        for (Map col : nonPkColumns) {
            sb.append("    private ").append(col.get(CommonConstant.COLUMN_TYPE)).append(" ").append(col.get(CommonConstant.COLUMN_NAME)).append(";\n");
        }

        sb.append("}\n");

        String filePath = BASE_PATH + ENTITY_CLASS_PACKAGE.replace(".", "/") +"/" + className + ".java";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(sb.toString());
        }
    }

    private static String toPascalCase(String text) {
        return Arrays.stream(text.split("_"))
                .map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase())
                .reduce("", String::concat);
    }

    private static String toCamelCase(String text) {
        String pascal = toPascalCase(text);
        return Character.toLowerCase(pascal.charAt(0)) + pascal.substring(1);
    }

    private static String toDataType(String text) {
        Map<String, String> typeMap = Map.of(
                "char", "String",
                "timestamp", "Timestamp",
                "bigint", "long",
                "int", "long",
                "decimal", "long",
                "double", "double",
                "date", "Date",
                "point", "String"
        );

        String lowerText = text.toLowerCase(); // 입력값 소문자로 변환

        for (String key : typeMap.keySet()) {
            if (lowerText.contains(key)) { // key와 비교 시에도 소문자
                return typeMap.get(key);
            }
        }
        return "Object"; // 기본값
    }
}