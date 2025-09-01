package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbVehicleAccMemsDataId;

@IdClass(TbVehicleAccMemsDataId.class)
@Entity
@Table( schema = "ufmslog", name = "tb_vehicle_acc_mems_data")
public class TbVehicleAccMemsData {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long event_no;
    @Id private Timestamp occured_dt;
    @Id private long vehicle_id;
    private String imei;
    private long event_type;
    private long measure;
    private Timestamp created_at;
    private String register_id;
    private String gps_info;
}
