package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbOpenapiHistoriesTempId;

@IdClass(TbOpenapiHistoriesTempId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_openapi_histories_temp")
public class TbOpenapiHistoriesTemp {
    @Id private Timestamp created_at;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long history_id;
    private long openapi_id;
    private long application_id;
    private long business_id;
    private long business_place_number;
    private String register_id;
    private String is_succ;
    private String client_ip;
}
