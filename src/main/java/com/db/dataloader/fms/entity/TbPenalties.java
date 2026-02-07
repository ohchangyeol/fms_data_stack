package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbPenaltiesId;

@IdClass(TbPenaltiesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_penalties")
public class TbPenalties {
    @Id private Timestamp imposition_dt;
    @Id private String reservation_number;
    private long suspension_days_number;
    private String penalty_type_cd;
    private String imposition_detail;
    private String contents;
    private String is_cancelled;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String cancelation_reason;
    private String updater_id;
}
