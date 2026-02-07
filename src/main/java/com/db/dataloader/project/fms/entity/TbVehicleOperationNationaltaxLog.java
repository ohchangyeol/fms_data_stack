package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbVehicleOperationNationaltaxLogId;

@IdClass(TbVehicleOperationNationaltaxLogId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_vehicle_operation_nationaltax_log")
public class TbVehicleOperationNationaltaxLog {
    @Id private Timestamp use_start_dt;
    @Id private long vehicle_id;
    private Timestamp use_end_dt;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private long before_odometer;
    private long after_odometer;
    private long init_odometer;
    private long personal_distance;
    private long business_distance;
    private String register_id;
    private String memo;
    private String updater_id;
    private String start_latitude;
    private String start_longitude;
    private String latitude;
    private String longitude;
    private String is_manual;
    private long record_id;
    private String driver_no;
    private String driver_name;
    private long business_place_number;
    private String business_place_name;
}
