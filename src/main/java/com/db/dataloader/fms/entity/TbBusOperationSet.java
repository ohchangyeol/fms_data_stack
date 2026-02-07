package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_bus_operation_set")
public class TbBusOperationSet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long set_id;
    private long vehicle_id;
    private String bus_route_number;
    private long base_id;
    private String is_upbound;
    private String is_active;
    private long sort_order;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String register_id;
    private String updated_id;
}
