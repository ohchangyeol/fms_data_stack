package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbSmsSendingHistoriesId;

@IdClass(TbSmsSendingHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_sms_sending_histories")
public class TbSmsSendingHistories {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long history_no;
    @Id private Timestamp sending_dt;
    private long manage_id;
    private String is_send_success;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String receiving_phone_number;
    private String receiving_email;
    private String updater_id;
}
