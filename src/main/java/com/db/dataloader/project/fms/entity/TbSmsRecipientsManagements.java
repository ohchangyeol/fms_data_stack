package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_sms_recipients_managements")
public class TbSmsRecipientsManagements {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long manage_id;
    private long template_no;
    private String is_personal;
    private String send_type_cd;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private long group_id;
    private Timestamp delivery_dt;
    private String updater_id;
}
