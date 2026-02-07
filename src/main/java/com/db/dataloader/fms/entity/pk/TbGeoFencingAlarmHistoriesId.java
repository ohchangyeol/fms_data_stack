package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbGeoFencingAlarmHistoriesId implements Serializable {
    private long geo_fencing_id;
    private String phone_number;
    private Timestamp send_dt;
    private long vehicle_id;
}
