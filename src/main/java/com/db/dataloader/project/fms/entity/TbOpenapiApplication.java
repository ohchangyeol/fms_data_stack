package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbOpenapiApplicationId;

@IdClass(TbOpenapiApplicationId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_openapi_application")
public class TbOpenapiApplication {
    @Id private long application_id;
    @Id private long openapi_id;
    private long business_id;
    private long business_place_number;
    private String service_name;
    private String use_status_type_cd;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String req_admin_no;
    private String approval_dt;
    private String process_admin_no;
    private String manager_name;
    private String use_suspension_dt;
    private String auth_token;
    private String memo;
    private String cipher;
    private String secure_key;
    private String updater_id;
}
