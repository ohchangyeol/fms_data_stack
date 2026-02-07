package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbDtcHistoriesId;

@IdClass(TbDtcHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_dtc_histories")
public class TbDtcHistories {
    @Id private String dtc_code;
    @Id private Timestamp occurrence_dt;
    @Id private long vehicle_id;
    private String imei;
    private Timestamp created_at;
    private String register_id;
}
