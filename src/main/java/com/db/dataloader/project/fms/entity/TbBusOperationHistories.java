package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbBusOperationHistoriesId;

@IdClass(TbBusOperationHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_bus_operation_histories")
public class TbBusOperationHistories {
    @Id private Timestamp arrived_dt;
    @Id private long base_id;
    @Id private String bus_route_number;
    @Id private String is_upbound;
    @Id private long vehicle_id;
    private Timestamp created_at;
    private long last_order;
    private String register_id;
    private String base_flag;
}
