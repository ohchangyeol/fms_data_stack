package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbVehicleAccKecoDataId;

@IdClass(TbVehicleAccKecoDataId.class)
@Entity
@Table( schema = "ufmslog", name = "tb_vehicle_acc_keco_data")
public class TbVehicleAccKecoData {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long event_no;
    @Id private Timestamp send_dt;
    @Id private long vehicle_id;
    private String imei;
    private long event_type;
    private Timestamp created_at;
    private String register_id;
    private long event_code;
}
