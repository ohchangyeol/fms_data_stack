package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_sms_token")
public class TbSmsToken {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long token_seq;
    private String token;
    private Timestamp token_created_at;
    private String refresh_token;
    private Timestamp rtoken_created_at;
}
