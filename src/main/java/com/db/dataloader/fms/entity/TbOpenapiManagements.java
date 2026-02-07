package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_openapi_managements")
public class TbOpenapiManagements {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long openapi_id;
    private String openapi_name;
    private String explanation;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
