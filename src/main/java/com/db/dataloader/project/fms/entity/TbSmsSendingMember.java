package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbSmsSendingMemberId;

@IdClass(TbSmsSendingMemberId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_sms_sending_member")
public class TbSmsSendingMember {
    @Id private long group_id;
    @Id private long seq;
    private String receiving_phone_number;
    private String receiving_email;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
