package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbPersonalInfoProvided3rdpartyId;

@IdClass(TbPersonalInfoProvided3rdpartyId.class)
@Entity
@Table( schema = "INITUFMSWD", name = "tb_personal_info_provided_3rdparty")
public class TbPersonalInfoProvided3rdparty {
    @Id private Timestamp created_at;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long provided_no;
    private String handler;
    private String recipient;
    private String provision_purpose;
    private String notification_method;
    private String register_id;
    private String recipient_email;
    private String provision_user_no;
    private String provision_user_name;
}
