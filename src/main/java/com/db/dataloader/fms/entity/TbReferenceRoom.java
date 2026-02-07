package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_reference_room")
public class TbReferenceRoom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long reference_id;
    private String title;
    private String note;
    private String is_period_setting;
    private Timestamp start_dt;
    private Timestamp end_dt;
    private long views;
    private String is_fixed_post;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
