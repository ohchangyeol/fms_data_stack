package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_user_widget_set")
public class TbUserWidgetSet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long set_no;
    private String admin_no;
    private long widget_id;
    private long width;
    private long height;
    private long x;
    private long y;
    private long max_width;
    private long max_height;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
