package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_geo_fencing_managements")
public class TbGeoFencingManagements {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long geo_fencing_id;
    private String geo_fencing_name;
    private String geo_fencing_type_cd;
    private String geo_fencing_info;
    private long radius_distance;
    private long business_id;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private long business_place_number;
    private Object polygon_info;
    private String updater_id;
}
