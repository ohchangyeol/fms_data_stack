package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbBaseVehicleInfoId;

@IdClass(TbBaseVehicleInfoId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_base_vehicle_info")
public class TbBaseVehicleInfo {
    @Id private long base_id;
    @Id private long vehicle_id;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
