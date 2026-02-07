package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_sms_template")
public class TbSmsTemplate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long template_no;
    private String template_classification_cd;
    private String title;
    private String contents;
    private String is_inspection_completed;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String register_id;
    private String updater_id;
}
