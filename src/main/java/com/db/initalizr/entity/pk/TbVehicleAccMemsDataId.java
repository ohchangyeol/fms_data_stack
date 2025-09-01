package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbVehicleAccMemsDataId implements Serializable {
    private long event_no;
    private Timestamp occured_dt;
    private long vehicle_id;
}
