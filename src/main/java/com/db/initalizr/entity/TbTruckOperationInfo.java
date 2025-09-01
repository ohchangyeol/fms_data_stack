package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbTruckOperationInfoId;

@IdClass(TbTruckOperationInfoId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_truck_operation_info")
public class TbTruckOperationInfo {
    @Id private long seq;
    @Id private long vehicle_id;
    private String vehicle_temperature;
    private Timestamp schedule_start_dt;
    private Timestamp schedule_end_dt;
    private String is_monday;
    private String is_tuesday;
    private String is_wednesday;
    private String is_thursday;
    private String is_friday;
    private String is_saturday;
    private String is_sunday;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String register_id;
    private String schedule_name;
    private String updater_id;
}
