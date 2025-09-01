package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_authority_managements")
public class TbAuthorityManagements {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long authority_id;
    private String authority_name;
    private String authority_classification_cd;
    private String service_identification_cd;
    private long business_id;
    private String is_select_only;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private long business_place_number;
    private String description;
    private String updater_id;
}
