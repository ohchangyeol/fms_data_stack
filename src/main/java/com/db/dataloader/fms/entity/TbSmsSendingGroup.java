package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_sms_sending_group")
public class TbSmsSendingGroup {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long group_id;
    private String group_name;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
