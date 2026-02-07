package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbSafetyDrivingDataId implements Serializable {
    private Timestamp created_at;
    private long vehicle_id;
}
