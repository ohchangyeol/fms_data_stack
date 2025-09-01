package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbCostStatisticsHistoriesId;

@IdClass(TbCostStatisticsHistoriesId.class)
@Entity
@Table( schema = "INITUFMSLOG", name = "tb_cost_statistics_histories")
public class TbCostStatisticsHistories {
    @Id private Timestamp cost_dt;
    @Id private String cost_statistics_classification_cd;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long history_no;
    @Id private long vehicle_id;
    private long cost_incurred;
    private String cost_status;
    private Timestamp created_at;
    private String register_id;
}
