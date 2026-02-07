package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbOperationStatisticsId;

@IdClass(TbOperationStatisticsId.class)
@Entity
@Table( schema = "ufmsnew", name = "tb_operation_statistics")
public class TbOperationStatistics {
    @Id private long business_id;
    @Id private long business_place_number;
    @Id private Date stat_dt;
    @Id private long vehicle_id;
    private String business_name;
    private String business_place_name;
    private String vehicle_number;
    private String model_name;
    private long work_time;
    private long operation_time;
    private long idling_time;
    private long operation_rate;
    private long operation_count;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
