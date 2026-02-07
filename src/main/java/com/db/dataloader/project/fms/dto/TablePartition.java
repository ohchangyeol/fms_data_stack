package com.db.dataloader.project.fms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TablePartition {

    private String tableSchema;
    private String tableName;
    private String createOptions;
}