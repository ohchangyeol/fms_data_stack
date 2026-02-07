package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbUnmaskingReasonHistoriesId;

@IdClass(TbUnmaskingReasonHistoriesId.class)
@Entity
@Table( schema = "INITUFMSWD", name = "tb_unmasking_reason_histories")
public class TbUnmaskingReasonHistories {
    @Id private Timestamp created_at;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long reason_no;
    private String reason;
    private String register_id;
}
