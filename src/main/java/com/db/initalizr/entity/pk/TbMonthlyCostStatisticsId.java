package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbMonthlyCostStatisticsId implements Serializable {
    private String cost_statistics_classification_cd;
    private String occurrence_month;
    private long vehicle_id;
}
