package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_contact_information")
public class TbContactInformation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long manager_no;
    private long business_id;
    private String is_parking_manager;
    private String is_base_manager;
    private String manager_name;
    private String manager_phone_number;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private long business_place_number;
    private long base_id;
    private String employee_email;
    private String department;
    private String employee_number;
    private String updater_id;
}
