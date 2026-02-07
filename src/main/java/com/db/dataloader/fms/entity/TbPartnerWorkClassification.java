package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbPartnerWorkClassificationId;

@IdClass(TbPartnerWorkClassificationId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_partner_work_classification")
public class TbPartnerWorkClassification {
    @Id private long business_id;
    @Id private String work_classification_cd;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String register_id;
    private String etc_classification_name;
    private String updater_id;
}
