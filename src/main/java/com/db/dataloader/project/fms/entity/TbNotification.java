package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_notification")
public class TbNotification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long notification_id;
    private String user_no;
    private String notification_message;
    private String notification_type_cd;
    private String notification_url;
    private String is_view;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
