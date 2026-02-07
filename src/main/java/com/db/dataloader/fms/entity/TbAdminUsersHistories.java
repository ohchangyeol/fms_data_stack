package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbAdminUsersHistoriesId;

@IdClass(TbAdminUsersHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_admin_users_histories")
public class TbAdminUsersHistories {
    @Id private String admin_no;
    @Id private Timestamp created_at;
    private String register_id;
    private long authority_id;
    private String password;
    private String authorization_approval_cd;
    private String name;
    private String is_employee_verified;
    private String department;
    private String phone_number;
    private String company_phone_number;
    private String reason;
    private String decision_admin_no;
    private Date permission_change_dt;
}
