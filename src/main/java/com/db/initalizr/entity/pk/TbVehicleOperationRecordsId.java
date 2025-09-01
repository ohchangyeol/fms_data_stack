package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbVehicleOperationRecordsId implements Serializable {
    private long record_id;
    private Timestamp use_start_dt;
    private long vehicle_id;
}
