package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTruckAlarmHistoriesId implements Serializable {
    private String phone_number;
    private Timestamp send_dt;
    private long vehicle_id;
}
