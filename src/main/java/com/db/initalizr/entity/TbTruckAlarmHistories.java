package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbTruckAlarmHistoriesId;

@IdClass(TbTruckAlarmHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_truck_alarm_histories")
public class TbTruckAlarmHistories {
    @Id private String phone_number;
    @Id private Timestamp send_dt;
    @Id private long vehicle_id;
    private String truck_alarm_type_cd;
    private Timestamp created_at;
    private String register_id;
    private String memo;
}
