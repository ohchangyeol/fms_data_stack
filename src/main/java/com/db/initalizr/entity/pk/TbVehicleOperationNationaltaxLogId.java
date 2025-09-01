package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbVehicleOperationNationaltaxLogId implements Serializable {
    private Timestamp use_start_dt;
    private long vehicle_id;
}
