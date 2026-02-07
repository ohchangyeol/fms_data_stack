package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbOpenapiHistoriesId;

@IdClass(TbOpenapiHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_openapi_histories")
public class TbOpenapiHistories {
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
