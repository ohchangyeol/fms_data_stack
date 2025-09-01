package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbVehicleSpeedingAlarmHistoriesId;

@IdClass(TbVehicleSpeedingAlarmHistoriesId.class)
@Entity
@Table( schema = "ufmsnew", name = "tb_vehicle_speeding_alarm_histories")
public class TbVehicleSpeedingAlarmHistories {
    @Id private String phone_number;
    @Id private Timestamp send_dt;
    @Id private long vehicle_id;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
    private String memo;
}
