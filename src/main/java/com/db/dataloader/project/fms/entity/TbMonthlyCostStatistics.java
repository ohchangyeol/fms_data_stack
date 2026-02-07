package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbMonthlyCostStatisticsId;

@IdClass(TbMonthlyCostStatisticsId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_monthly_cost_statistics")
public class TbMonthlyCostStatistics {
    @Id private String cost_statistics_classification_cd;
    @Id private String occurrence_month;
    @Id private long vehicle_id;
    private long cost_incurred;
    private Timestamp created_at;
    private String register_id;
}
