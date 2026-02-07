package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbLoginHistoriesId;

@IdClass(TbLoginHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_login_histories")
public class TbLoginHistories {
    @Id private Timestamp created_at;
    @Id private String user_no;
    private String login_job_type_cd;
    private String is_active;
    private String register_id;
}
