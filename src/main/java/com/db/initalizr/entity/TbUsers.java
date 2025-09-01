package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_users")
public class TbUsers {
    @Id private String user_no;
    private String login_id;
    private String password;
    private long business_id;
    private String user_classification_cd;
    private String is_team_leader;
    private String user_name;
    private String is_admin_verified;
    private String is_employment;
    private String is_driver_license_verified;
    private String is_inactive_user;
    private long errors_count;
    private Date password_set_date;
    private String is_withdrawal_user;
    private String is_pin_use;
    private long pin_errors_count;
    private String is_sms_marketing;
    private String is_sms_advertizement;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private long business_place_number;
    private long authority_id;
    private String decision_admin_no;
    private Date approval_request_dt;
    private Date approval_completion_dt;
    private String admin_memo;
    private Date admin_decision_dt;
    private String pin_number;
    private String auth_token;
    private String refresh_token;
    private String phone_number;
    private String company_phone_number;
    private Timestamp login_time;
    private Date birth_dt;
    private String process_admin_no;
    private String appuser_classification_cd;
    private String updater_id;
    private Timestamp sms_marketing_agreed_at;
    private Timestamp sms_advertizement_agreed_at;
    private String change_type_cd;
}
