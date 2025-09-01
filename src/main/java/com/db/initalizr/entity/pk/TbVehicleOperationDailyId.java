package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbVehicleOperationDailyId implements Serializable {
    private Date stat_day;
    private String user_no;
    private long vehicle_id;
}
