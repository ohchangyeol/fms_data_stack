package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbDailyRentalStatisticsId;

@IdClass(TbDailyRentalStatisticsId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_daily_rental_statistics")
public class TbDailyRentalStatistics {
    @Id private long business_id;
    @Id private String rental_status;
    @Id private Date statistics_dt;
    private long rental_status_count;
    private Timestamp created_at;
    private String register_id;
    private long business_place_number;
}
