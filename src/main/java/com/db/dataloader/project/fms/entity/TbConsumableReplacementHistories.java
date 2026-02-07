package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbConsumableReplacementHistoriesId;

@IdClass(TbConsumableReplacementHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_consumable_replacement_histories")
public class TbConsumableReplacementHistories {
    @Id private long consumable_id;
    @Id private Date replacement_dt;
    @Id private long vehicle_id;
    private long replacement_amount;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private long cumulative_distance;
    private String memo;
    private String updater_id;
}
