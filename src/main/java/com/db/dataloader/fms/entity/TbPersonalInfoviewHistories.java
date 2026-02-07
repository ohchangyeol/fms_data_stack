package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbPersonalInfoviewHistoriesId;

@IdClass(TbPersonalInfoviewHistoriesId.class)
@Entity
@Table( schema = "INITUFMSWD", name = "tb_personal_infoview_histories")
public class TbPersonalInfoviewHistories {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long history_no;
    @Id private Timestamp search_target_dt;
    private String search_target_type;
    private String search_target_content;
    private String search_target_menu;
    private String search_user_no;
    private String search_target_no;
    private Timestamp created_at;
    private String register_id;
}
