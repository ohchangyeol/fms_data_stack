package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbVehicleOperationEventDataTempId;

@IdClass(TbVehicleOperationEventDataTempId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_vehicle_operation_event_data_temp")
public class TbVehicleOperationEventDataTemp {
    @Id private Timestamp occured_dt;
    @Id private long vehicle_id;
    private long event_type;
    private long event_count;
    private long event_parameter;
    private long event_ref_value;
    private String gps_info;
    private Timestamp created_at;
    private String register_id;
}
