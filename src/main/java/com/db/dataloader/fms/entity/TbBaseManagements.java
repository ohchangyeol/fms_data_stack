package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_base_managements")
public class TbBaseManagements {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long base_id;
    private String base_name;
    private long business_id;
    private String service_type_cd;
    private String base_classification_cd;
    private String base_address;
    private String base_post_cd;
    private Object poi;
    private long radius_distance;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private long business_place_number;
    private String base_address_detail;
    private String file_id;
    private String updater_id;
}
