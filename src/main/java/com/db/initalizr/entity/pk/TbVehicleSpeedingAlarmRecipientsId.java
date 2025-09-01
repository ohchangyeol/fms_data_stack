package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbVehicleSpeedingAlarmRecipientsId implements Serializable {
    private String phone_number;
    private long vehicle_id;
}
