package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_device_state_code")
public class TbDeviceStateCode {
    @Id private String device_error_code;
    private String device_error_memo;
    private Timestamp created_at;
    private String register_id;
}
