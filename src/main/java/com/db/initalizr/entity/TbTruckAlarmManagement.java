package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_truck_alarm_management")
public class TbTruckAlarmManagement {
    @Id private long vehicle_id;
    private String is_recept;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
    private String memo;
}
