package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_business")
public class TbBusiness {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long business_id;
    private String business_name;
    private String business_registration_number;
    private String address;
    private String address_detail;
    private String post_cd;
    private String corporation_code;
    private String is_use;
    private String is_corporation;
    private String is_rental_auto_approval;
    private String is_partner;
    private String company_classification_cd;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String representative_number;
    private String file_id;
    private String memo;
    private String ceo;
    private String mail_order_report;
    private String customer_service_center;
    private String updater_id;
    private String cert_key;
    private String is_poc;
}
