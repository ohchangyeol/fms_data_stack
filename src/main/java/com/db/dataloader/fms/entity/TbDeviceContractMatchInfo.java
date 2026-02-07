package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbDeviceContractMatchInfoId;

@IdClass(TbDeviceContractMatchInfoId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_device_contract_match_info")
public class TbDeviceContractMatchInfo {
    @Id private String model_no;
    @Id private String serial_number;
    private String firmware_version;
    private String is_service;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
