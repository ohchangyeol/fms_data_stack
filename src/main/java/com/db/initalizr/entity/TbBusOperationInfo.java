package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbBusOperationInfoId;

@IdClass(TbBusOperationInfoId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_bus_operation_info")
public class TbBusOperationInfo {
    @Id private String bus_route_number;
    @Id private long vehicle_id;
    private String weekday_dispatch_interval;
    private String weekday_first_bus;
    private String weekday_last_bus;
    private String weekend_dispatch_interval;
    private String weekend_first_bus;
    private String weekend_last_bus;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updated_id;
}
