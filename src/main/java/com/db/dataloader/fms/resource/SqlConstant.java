package com.db.dataloader.fms.resource;

public class SqlConstant {
    public static final String COUNT_START_SQL = "SELECT tableSchema, tableName, tableFullName, baseCount, currentCount, baseCount - currentCount AS differenceCount, CASE WHEN baseCount <= currentCount THEN 'true' ELSE 'false' END AS matchStatus FROM\s (";
    public static final String COUNT_MAIN_SQL = "SELECT '%s' AS 'tableSchema' ,'%s' AS 'tableName', '%s' AS 'tableFullName', %s AS 'baseCount', COUNT(*) AS 'currentCount' FROM %s %s\s";
    public static final String COUNT_END_SQL = ") AS RESULT ORDER BY matchStatus asc;";

    public static final String INSERT_SQL = "INSERT INTO %s.%s\n( %s )\nVALUES\n( %s );";

}
