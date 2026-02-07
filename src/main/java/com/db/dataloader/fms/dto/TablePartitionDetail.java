package com.db.dataloader.fms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TablePartitionDetail {

    private String tableSchema;
    private String tableName;
    private String partitionName;
    private long tableRows;
    private String yearMonth;
}