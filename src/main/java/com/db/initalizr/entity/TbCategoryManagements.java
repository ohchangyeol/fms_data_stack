package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_category_managements")
public class TbCategoryManagements {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long category_no;
    private String category_name;
    private String title;
    private long sort_order;
    private String is_use;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
