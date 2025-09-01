package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbAccidentVehiclesId;

@IdClass(TbAccidentVehiclesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_accident_vehicles")
public class TbAccidentVehicles {
    @Id private Timestamp accident_dt;
    @Id private long vehicle_id;
    private String accident_vehicle_type_cd;
    private String user_no;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String accident_number;
    private String phone_number;
    private String file_id;
    private String memo;
    private String updater_id;
}
