package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbBusOperationHistoriesId implements Serializable {
    private Timestamp arrived_dt;
    private long base_id;
    private String bus_route_number;
    private String is_upbound;
    private long vehicle_id;
}
