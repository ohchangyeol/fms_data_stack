package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbFinesId;

@IdClass(TbFinesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_fines")
public class TbFines {
    @Id private String user_no;
    @Id private Timestamp violation_dt;
    private long vehicle_id;
    private String fine_items;
    private long fine_amount;
    private String is_payment;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String deposit_bank;
    private String payment_account_number;
    private String competent_agency;
    private String inquiry_phone_number;
    private Date payment_due_dt;
    private String memo;
    private String updater_id;
}
