package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbFmsDeviceNumberId;

@IdClass(TbFmsDeviceNumberId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_fms_device_number")
public class TbFmsDeviceNumber {
    @Id private String fms_device_number;
    @Id private String model_no;
    @Id private long vehicle_id;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private double init_odometer;
    private String phone_number;
    private String usim_model_name;
    private String usim_serial_number;
    private String updater_id;
    private String can_type;
    private String can_status;
    private Timestamp can_on_dt;
    private Timestamp can_off_dt;
    private String can_req_id;
}
