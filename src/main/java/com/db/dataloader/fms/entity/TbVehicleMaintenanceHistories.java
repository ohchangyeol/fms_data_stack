package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbVehicleMaintenanceHistoriesId;

@IdClass(TbVehicleMaintenanceHistoriesId.class)
@Entity
@Table( schema = "INITUFMSLOG", name = "tb_vehicle_maintenance_histories")
public class TbVehicleMaintenanceHistories {
    @Id private Timestamp can_on_dt;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long request_no;
    @Id private long vehicle_id;
    private String fms_device_number;
    private String can_type;
    private String can_status;
    private String can_req_id;
    private Timestamp created_at;
    private String register_id;
    private String request_result;
}
