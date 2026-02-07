package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_widget_managements")
public class TbWidgetManagements {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long widget_id;
    private String widget_name;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
