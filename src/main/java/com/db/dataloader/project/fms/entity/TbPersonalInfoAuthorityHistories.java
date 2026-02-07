package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbPersonalInfoAuthorityHistoriesId;

@IdClass(TbPersonalInfoAuthorityHistoriesId.class)
@Entity
@Table( schema = "INITUFMSWD", name = "tb_personal_info_authority_histories")
public class TbPersonalInfoAuthorityHistories {
    @Id private Timestamp created_at;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long history_no;
    private String admin_no;
    private long authority_id;
    private String authority_classification_cd;
    private String change_type;
    private String change_reason;
    private String register_id;
}
