package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbCostStatisticsHistoriesId implements Serializable {
    private Timestamp cost_dt;
    private String cost_statistics_classification_cd;
    private long history_no;
    private long vehicle_id;
}
