package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_direct_inquiry")
public class TbDirectInquiry {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long inquiry_id;
    private long business_id;
    private String inquiry_title;
    private String inquiry;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private long business_place_number;
    private String answer;
    private Timestamp answer_dt;
    private String updater_id;
}
