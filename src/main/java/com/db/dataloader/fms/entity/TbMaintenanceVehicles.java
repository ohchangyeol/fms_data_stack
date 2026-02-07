package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbMaintenanceVehiclesId;

@IdClass(TbMaintenanceVehiclesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_maintenance_vehicles")
public class TbMaintenanceVehicles {
    @Id private Date receipt_dt;
    @Id private long vehicle_id;
    private String maintenance_purpose;
    private long maintenance_cost;
    private Date deliver_dt;
    private String is_cost_including_accident;
    private String is_regular_inspection;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String note;
    private String updater_id;
}
