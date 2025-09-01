-- name: findColumnDetails
SELECT
    TABLE_SCHEMA AS tableSchema,
    TABLE_NAME AS tableName,
    CASE
        WHEN COLUMN_TYPE LIKE 'varchar%' THEN 'String'
        WHEN COLUMN_TYPE LIKE 'char%' THEN 'String'
        WHEN COLUMN_TYPE LIKE 'timestamp%' THEN 'Timestamp'
        WHEN COLUMN_TYPE LIKE 'bigint%' THEN 'long'
        WHEN COLUMN_TYPE LIKE 'int%' THEN 'long'
        WHEN COLUMN_TYPE LIKE 'decimal%' AND NUMERIC_SCALE = 0 THEN 'long'
        WHEN COLUMN_TYPE LIKE 'decimal%' AND NUMERIC_SCALE > 0 THEN 'double'
        WHEN COLUMN_TYPE LIKE 'double%' THEN 'double'
        WHEN COLUMN_TYPE LIKE 'date%' THEN 'Date'
        WHEN COLUMN_TYPE LIKE 'point%' THEN 'String'
        ELSE COLUMN_TYPE
    END AS columnType,
    COLUMN_TYPE AS columnTypeOrigin,
    IFNULL(CHARACTER_MAXIMUM_LENGTH, IFNULL(NUMERIC_PRECISION, 0)) AS characterMaximumLength,
    COLUMN_NAME AS columnName,
    IS_NULLABLE AS isNullable,
    COLUMN_DEFAULT AS columnDefault,
    COLUMN_KEY AS columnKey,
    EXTRA AS extra
FROM
    information_schema.COLUMNS
WHERE
    TABLE_SCHEMA = :schema
    AND TABLE_NAME = :table;

-- name: findPartitionTable
SELECT
    TABLE_SCHEMA,
    TABLE_NAME,
    CREATE_OPTIONS
FROM
    information_schema.TABLES
where
    CREATE_OPTIONS LIKE '%partitioned%';

-- name: findPartitionCount
SELECT
    TABLE_SCHEMA,
    TABLE_NAME,
    PARTITION_NAME,
    TABLE_ROWS,
    DATE_FORMAT(
        FROM_UNIXTIME(
            LAG(PARTITION_DESCRIPTION, 1, PARTITION_DESCRIPTION - 2629743) OVER (
                PARTITION BY TABLE_SCHEMA, TABLE_NAME ORDER BY PARTITION_DESCRIPTION
            )
        ),
        '%Y%m'
    ) AS 'YEAR_MONTH'
FROM
    information_schema.PARTITIONS
WHERE
    TABLE_SCHEMA = :schema
    AND TABLE_NAME = :table
ORDER BY partition_name ASC;