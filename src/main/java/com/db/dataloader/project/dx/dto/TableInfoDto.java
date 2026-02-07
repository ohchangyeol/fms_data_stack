package com.db.dataloader.project.dx.dto;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
public class TableInfoDto {
    private String table;
    private int monthCnt;
    private String select;
    private boolean ignore;
    private List<String> partitions = new LinkedList<>();
    private Map<String, String> data = new LinkedHashMap<>();
    private int batchSize = 1000;
}
