package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_mobile_contract_device_installation_request")
public class TbMobileContractDeviceInstallationRequest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long request_no;
    private String subscription_id;
    private String contract_id;
    private long business_id;
    private String task_type_cd;
    private String is_mapping;
    private String is_work_end;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private long vehicle_id;
    private long prev_vehicle_id;
    private String comment;
    private String memo;
    private Timestamp work_end_dt;
    private String processing_user_name;
    private String updater_id;
}
