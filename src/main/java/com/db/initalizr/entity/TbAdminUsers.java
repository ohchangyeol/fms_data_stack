package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_admin_users")
public class TbAdminUsers {
    @Id private String admin_no;
    private long business_id;
    private String login_id;
    private String name;
    private String password;
    private String is_employee_verified;
    private String authorization_approval_cd;
    private String is_account_suspended;
    private String user_classification_cd;
    private String is_sms_marketing;
    private String is_sms_advertizement;
    private String is_inactive_user;
    private String is_withdrawal_user;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private long business_place_number;
    private long authority_id;
    private String auth_token;
    private String refresh_token;
    private String department;
    private String phone_number;
    private String company_phone_number;
    private String reason;
    private String decision_admin_no;
    private Date permission_change_dt;
    private long errors_count;
    private Date password_set_date;
    private String memo;
    private String updater_id;
    private Timestamp sms_marketing_agreed_at;
    private Timestamp sms_advertizement_agreed_at;
    private String change_type_cd;
}
