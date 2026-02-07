package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbVehicleOperationDailyId;

@IdClass(TbVehicleOperationDailyId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_vehicle_operation_daily")
public class TbVehicleOperationDaily {
    @Id private Date stat_day;
    @Id private String user_no;
    @Id private long vehicle_id;
    private Timestamp use_start_dt;
    private long before_odometer;
    private long user_odometer;
    private long user_cum_time;
    private long avg_speed;
    private long max_speed;
    private long mileage;
    private long mileage_index;
    private long rapid_acceleration;
    private long rapid_deceleration;
    private long sudden_start;
    private long sudden_stop;
    private long rapid_turn;
    private long rapid_u_turn;
    private long rapid_lane_change;
    private long rapid_passing;
    private long idling_sec;
    private long over_speed;
    private long enter_idling;
    private long carbon_dioxide_emissions;
    private long fuel_consumption;
    private long safe_driving_index;
    private long echo_driving_index;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
