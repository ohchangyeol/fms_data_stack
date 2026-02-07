package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbVehicleOperationRecordsId;

@IdClass(TbVehicleOperationRecordsId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_vehicle_operation_records")
public class TbVehicleOperationRecords {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long record_id;
    @Id private Timestamp use_start_dt;
    @Id private long vehicle_id;
    private String year;
    private Timestamp use_end_dt;
    private long before_odometer;
    private long after_odometer;
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
    private String user_no;
    private String longitude;
    private String latitude;
    private String updater_id;
    private String start_longitude;
    private String start_latitude;
    private String key_state_flag;
}
