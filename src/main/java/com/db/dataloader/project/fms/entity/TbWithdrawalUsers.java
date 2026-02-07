package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSWD", name = "tb_withdrawal_users")
public class TbWithdrawalUsers {
    @Id private String user_no;
    private String user_name;
    private String withdrawal_reason;
    private Timestamp created_at;
    private String register_id;
    private String phone_number;
    private String employee_email;
    private String company_phone_number;
}
