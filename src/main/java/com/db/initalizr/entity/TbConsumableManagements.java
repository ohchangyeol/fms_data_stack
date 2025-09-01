package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_consumable_managements")
public class TbConsumableManagements {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long consumable_id;
    private String consumables_name;
    private long maintenance_period;
    private long maintenance_distance;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
