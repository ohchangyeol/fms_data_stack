package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbPersonalInfoViewConfirmId;

@IdClass(TbPersonalInfoViewConfirmId.class)
@Entity
@Table( schema = "INITUFMSWD", name = "tb_personal_info_view_confirm")
public class TbPersonalInfoViewConfirm {
    @Id private Timestamp view_dt;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long view_no;
    private String handler;
    private String view_user_no;
    private String view_user_name;
    private String reading_purpose;
    private String etc_reading_purpose;
    private String search_options;
    private Timestamp created_at;
    private String register_id;
}
