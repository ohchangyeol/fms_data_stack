package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbDeviceDisabilityHistoryId;

@IdClass(TbDeviceDisabilityHistoryId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_device_disability_history")
public class TbDeviceDisabilityHistory {
    @Id private Timestamp disability_dt;
    @Id private String error_code;
    @Id private long vehicle_id;
    private String imei;
    private String error_memo;
    private Timestamp created_at;
    private String register_id;
}
