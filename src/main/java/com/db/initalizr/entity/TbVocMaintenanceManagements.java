package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_voc_maintenance_managements")
public class TbVocMaintenanceManagements {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long maintenance_id;
    private String voc_identification_cd;
    private Date receipt_dt;
    private long business_id;
    private long vehicle_id;
    private String model_no;
    private String appication_detail;
    private String work_cost_identification_cd;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private long business_place_number;
    private long processing_business_id;
    private String processing_identification_cd;
    private String contract_phone_number;
    private String manager_name;
    private String manager_phone_number;
    private String memo;
    private String etc;
    private String processing_detail;
    private Date due_dt;
    private String processing_user_name;
    private String processing_phone_number;
    private String updater_id;
}
