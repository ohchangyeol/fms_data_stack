package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_device_managements")
public class TbDeviceManagements {
    @Id private String model_no;
    private long business_id;
    private String model_name;
    private String device_classification_cd;
    private String is_message_support;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
