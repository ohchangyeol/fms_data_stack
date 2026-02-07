package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbGeoFencingAlarmHistoriesTempId;

@IdClass(TbGeoFencingAlarmHistoriesTempId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_geo_fencing_alarm_histories_temp")
public class TbGeoFencingAlarmHistoriesTemp {
    @Id private String phone_number;
    @Id private Timestamp send_dt;
    @Id private long vehicle_id;
    private Timestamp created_at;
    private String register_id;
    private String geo_fencing_alarm_type_cd;
    private String memo;
}
