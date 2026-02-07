package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_vehicle_special_equipment")
public class TbVehicleSpecialEquipment {
    @Id private long vehicle_id;
    private String equipment_name;
    private String equipment_classification_cd;
    private String equipment_detail_classification_cd;
    private String manufacturing_company;
    private String equipment_model;
    private String equipment_mission;
    private String equipment_lower_type;
    private String is_active;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updater_id;
}
