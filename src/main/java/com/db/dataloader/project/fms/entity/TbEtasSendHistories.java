package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbEtasSendHistoriesId;

@IdClass(TbEtasSendHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_etas_send_histories")
public class TbEtasSendHistories {
    @Id private Timestamp created_at;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long send_no;
    private long record_id;
    private String business_registration_number;
    private long business_id;
    private long vehicle_id;
    private String imei;
    private long response_code;
    private String response_message;
    private long retransmissions_number;
    private String register_id;
    private String dtg_file_name;
}
