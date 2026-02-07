package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_vehicles")
public class TbVehicles {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long vehicle_id;
    private long business_id;
    private String vehicle_number;
    private String registration_file_id;
    private String is_active;
    private String use_classification_cd;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private long regular_inspection_cycle;
    private String service_type_cd;
    private long cumulative_driving_distance;
    private String is_control_status;
    private String driver_license_type_cd;
    private long vehicle_model_id;
    private long business_place_number;
    private String fms_device_number;
    private long gps_transmission_frequency;
    private String user_no;
    private String business_registration_number;
    private long tonnage;
    private String vehicle_year_year;
    private String vehicle_year_month;
    private String vehicle_identification_number;
    private String note;
    private long carbon_dioxide_emissions;
    private String updater_id;
}
