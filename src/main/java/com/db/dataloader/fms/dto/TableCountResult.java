package com.db.dataloader.fms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableCountResult {
    private String tableSchema;         // 스키마
    private String tableName;           // 테이블명
    private String tableFullName;       // 스키마+테이블명
    private int baseCount;              // 기준건수
    private int currentCount;           // 현재건수
    private int differenceCount;        // 차이 건수 : 기준 - 현재
    private boolean matchStatus;         // 일치여부 : true/false
}