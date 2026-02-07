package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbNationalTaxServiceId;

@IdClass(TbNationalTaxServiceId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_national_tax_service")
public class TbNationalTaxService {
    @Id private Timestamp use_start_dt;
    @Id private long vehicle_id;
    private String user_no;
    private Timestamp use_end_dt;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private long before_odometer;
    private long after_odometer;
    private long personal_distance;
    private long business_distance;
    private String register_id;
    private String memo;
    private String updater_id;
}
