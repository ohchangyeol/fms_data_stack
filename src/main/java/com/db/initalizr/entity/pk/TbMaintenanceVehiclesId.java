package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbMaintenanceVehiclesId implements Serializable {
    private Date receipt_dt;
    private long vehicle_id;
}
