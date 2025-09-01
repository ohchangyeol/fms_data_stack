package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbVehicleMaintenanceHistoriesId implements Serializable {
    private Timestamp can_on_dt;
    private long request_no;
    private long vehicle_id;
}
