package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbCostStatisticsId implements Serializable {
    private String cost_statistics_classification_cd;
    private Timestamp occurrence_dt;
    private long vehicle_id;
}
