package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_banner_information")
public class TbBannerInformation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long banner_no;
    private long category_no;
    private String is_use_url;
    private String is_posting;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String file_id;
    private String connection_button_name;
    private String background_color;
    private long posting_order;
    private String connection_url;
    private String updater_id;
}
