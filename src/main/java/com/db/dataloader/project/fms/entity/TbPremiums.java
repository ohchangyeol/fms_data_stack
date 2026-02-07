package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbPremiumsId;

@IdClass(TbPremiumsId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_premiums")
public class TbPremiums {
    @Id private long seq;
    @Id private long vehicle_id;
    private String insurance_company;
    private String insurance_product;
    private String is_monthly_payment;
    private long premium;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String monthly_payment_day;
    private Date payment_dt;
    private Date contract_start_dt;
    private Date contract_end_dt;
    private String memo;
    private String updater_id;
}
