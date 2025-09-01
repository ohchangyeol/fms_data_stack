package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbTruckDeliveryHistoriesId;

@IdClass(TbTruckDeliveryHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_truck_delivery_histories")
public class TbTruckDeliveryHistories {
    @Id private long base_id;
    @Id private Timestamp entry_dt;
    @Id private long seq;
    @Id private long vehicle_id;
    private long last_order;
    private Timestamp created_at;
    private String register_id;
    private long distance;
    private Timestamp arrived_dt;
    private Timestamp departure_dt;
    private long entry_front_temperature;
    private long departure_front_temperature;
    private long entry_back_temperature;
    private long departure_back_temperature;
    private String quit_sign_file_id;
    private Timestamp quit_sign_dt;
    private String loading_sign_file_id;
    private Timestamp loading_sign_dt;
}
