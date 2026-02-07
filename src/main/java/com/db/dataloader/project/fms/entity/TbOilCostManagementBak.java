package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbOilCostManagementBakId;

@IdClass(TbOilCostManagementBakId.class)
@Entity
@Table( schema = "ufmsnew", name = "tb_oil_cost_management_bak")
public class TbOilCostManagementBak {
    @Id private Timestamp refueling_dt;
    @Id private long vehicle_id;
    private long fuel_amount;
    private long payment_amount;
    private String memo;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String user_no;
    private String phone_number;
    private String updater_id;
}
