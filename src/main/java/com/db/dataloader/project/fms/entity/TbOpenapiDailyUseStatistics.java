package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbOpenapiDailyUseStatisticsId;

@IdClass(TbOpenapiDailyUseStatisticsId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_openapi_daily_use_statistics")
public class TbOpenapiDailyUseStatistics {
    @Id private long application_id;
    @Id private long openapi_id;
    @Id private Date statistics_dt;
    private long relays_count;
    private long normal_termination_count;
    private String starting_point;
    private String end_point;
    private long business_id;
    private Timestamp created_at;
    private String register_id;
    private long business_place_number;
}
