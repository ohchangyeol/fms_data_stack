package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbSmsRecipientsId;

@IdClass(TbSmsRecipientsId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_sms_recipients")
public class TbSmsRecipients {
    @Id private long manage_id;
    @Id private long seq;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String receiving_phone_number;
    private String receiving_email;
    private String updater_id;
}
