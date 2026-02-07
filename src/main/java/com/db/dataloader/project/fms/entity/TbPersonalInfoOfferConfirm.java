package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbPersonalInfoOfferConfirmId;

@IdClass(TbPersonalInfoOfferConfirmId.class)
@Entity
@Table( schema = "INITUFMSWD", name = "tb_personal_info_offer_confirm")
public class TbPersonalInfoOfferConfirm {
    @Id private Timestamp offer_dt;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long offer_no;
    private String search_user_no;
    private String search_login_id;
    private String search_user_name;
    private String presentation_method_cd;
    private String acquire_method_cd;
    private String presentation_category_cd;
    private String imei;
    private String driver_user_no;
    private String driver_login_id;
    private String driver_user_name;
    private Timestamp created_at;
    private String register_id;
}
