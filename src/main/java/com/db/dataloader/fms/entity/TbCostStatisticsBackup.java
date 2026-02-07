package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbCostStatisticsBackupId;

@IdClass(TbCostStatisticsBackupId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_cost_statistics_backup")
public class TbCostStatisticsBackup {
    @Id private String cost_statistics_classification_cd;
    @Id private Timestamp occurrence_dt;
    @Id private long vehicle_id;
    private long cost_incurred;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
}
