package com.db.initalizr.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableColumnDetail {

    private String tableSchema;
    private String tableName;
    private String columnType;
    private String columnTypeOrigin;
    private long characterMaximumLength;
    private String columnName;
    private String isNullable;
    private String columnDefault;
    private String columnKey;
    private String extra;

}