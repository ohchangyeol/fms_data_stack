package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_notices")
public class TbNotices {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long notice_no;
    private String title;
    private String content;
    private String is_fixed_post;
    private String is_period_setting;
    private Timestamp start_dt;
    private Timestamp end_dt;
    private String is_posting;
    private long views;
    private String is_external_url_connection;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String notice_type_cd;
    private String is_popup;
    private String file_id;
    private String updater_id;
    private String aos_version;
    private String ios_version;
}
