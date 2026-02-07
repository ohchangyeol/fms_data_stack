package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_vehicle_bus")
public class TbVehicleBus {
    @Id private long vehicle_id;
    private String bus_route_number;
    private String vehicle_type;
    private String bus_type_cd;
    private String bus_detail_type_cd;
    private long passengers_number;
    private String is_active;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String etc_name;
    private String updater_id;
}
