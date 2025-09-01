package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_inactive_users")
public class TbInactiveUsers {
    @Id private String user_no;
    private long business_id;
    private String login_id;
    private String user_classification_cd;
    private String is_team_leader;
    private String user_name;
    private String is_admin_verified;
    private String is_employment;
    private String is_driver_license_verified;
    private Timestamp created_at;
    private String register_id;
    private long business_place_number;
    private String phone_number;
    private String employee_email;
    private String company_phone_number;
    private Date birth_dt;
}
