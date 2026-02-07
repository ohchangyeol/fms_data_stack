package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbTruckOperationSetId;

@IdClass(TbTruckOperationSetId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_truck_operation_set")
public class TbTruckOperationSet {
    @Id private long base_id;
    @Id private long seq;
    @Id private long vehicle_id;
    private Object schedule_start_time;
    private Object schedule_end_time;
    private String is_loading;
    private String is_quit;
    private String is_active;
    private long sort_order;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String register_id;
    private String updater_id;
}
