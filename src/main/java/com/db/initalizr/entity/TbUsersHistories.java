package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbUsersHistoriesId;

@IdClass(TbUsersHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_users_histories")
public class TbUsersHistories {
    @Id private Timestamp created_at;
    @Id private String user_no;
    private String password;
    private String user_classification_cd;
    private String is_team_leader;
    private String user_name;
    private String is_admin_verified;
    private String is_employment;
    private String is_driver_license_verified;
    private String is_inactive_user;
    private Date password_set_date;
    private String is_withdrawal_user;
    private String is_pin_use;
    private String is_sms_marketing;
    private String is_sms_advertizement;
    private String register_id;
    private Timestamp updated_at;
    private long authority_id;
    private String decision_admin_no;
    private Date approval_request_dt;
    private Date approval_completion_dt;
    private Date admin_decision_dt;
    private String pin_number;
    private String phone_number;
    private String company_phone_number;
    private Date birth_dt;
    private String appuser_classification_cd;
}
