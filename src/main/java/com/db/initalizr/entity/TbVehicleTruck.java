package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_vehicle_truck")
public class TbVehicleTruck {
    @Id private long vehicle_id;
    private String truck_classification_cd;
    private String is_fixed_back;
    private long back_start_temperature;
    private long back_end_temperature;
    private String is_fixed_front;
    private long front_start_temperature;
    private long front_end_temperature;
    private String is_owner;
    private String settlement_type_cd;
    private String is_active;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String deposit_bank;
    private String account_holder;
    private String deposit_account_number;
    private String updater_id;
}
