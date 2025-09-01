package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbSafetyDrivingDataId;

@IdClass(TbSafetyDrivingDataId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_safety_driving_data")
public class TbSafetyDrivingData {
    @Id private Timestamp created_at;
    @Id private long vehicle_id;
    private String imei;
    private long rapid_acceleration;
    private long rapid_deceleration;
    private long sudden_stop;
    private long rapid_turn;
    private long rapid_u_turn;
    private long rapid_lane_change;
    private long rapid_passing;
    private long sudden_start;
    private long enter_idling;
}
