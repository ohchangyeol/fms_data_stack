package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_vehicles_model_management")
public class TbVehiclesModelManagement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long vehicle_model_id;
    private String manufacturer_classification_cd;
    private String model_classification_cd;
    private String model_year;
    private String fuel_classification_cd;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String file_id;
    private String vehicle_size_classification_cd;
    private String updater_id;
}
