package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbTermConditionsId;

@IdClass(TbTermConditionsId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_term_conditions")
public class TbTermConditions {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long term_id;
    @Id private long version;
    private long business_id;
    private String category_cd;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String subject;
    private Object content;
    private String is_essential;
    private String register_id;
    private Date application_dt;
    private String updater_id;
}
