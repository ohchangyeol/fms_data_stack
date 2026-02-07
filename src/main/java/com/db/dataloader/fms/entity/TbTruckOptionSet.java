package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbTruckOptionSetId;

@IdClass(TbTruckOptionSetId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_truck_option_set")
public class TbTruckOptionSet {
    @Id private String truck_option_cd;
    @Id private long vehicle_id;
    private String is_active;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String updater_id;
}
