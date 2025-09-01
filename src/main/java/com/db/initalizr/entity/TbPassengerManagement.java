package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbPassengerManagementId;

@IdClass(TbPassengerManagementId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_passenger_management")
public class TbPassengerManagement {
    @Id private String passenger_no;
    @Id private long vehicle_id;
    private String passenger_type_cd;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String passenger_name;
    private String phone_number;
    private String department;
    private String boarding_location;
    private String detail_location;
    private long base_id;
    private String register_id;
    private String note;
    private String updater_id;
}
