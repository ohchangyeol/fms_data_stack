package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbBusBoardingInfoId;

@IdClass(TbBusBoardingInfoId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_bus_boarding_info")
public class TbBusBoardingInfo {
    @Id private String boarding_identification_number;
    @Id private long vehicle_id;
    private String boarding_type_cd;
    private String passenger_name;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String register_id;
    private long base_id;
    private String registration_purpose;
    private String memo;
    private String guardian_name;
    private String phone_number1;
    private String phone_number2;
    private String phone_number3;
    private String updated_id;
}
