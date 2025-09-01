package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbBusOperationInfoId implements Serializable {
    private String bus_route_number;
    private long vehicle_id;
}
