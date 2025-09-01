package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_geo_fencing_applied_vehicle")
public class TbGeoFencingAppliedVehicle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long apply_no;
    private long geo_fencing_id;
    private long vehicle_id;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
