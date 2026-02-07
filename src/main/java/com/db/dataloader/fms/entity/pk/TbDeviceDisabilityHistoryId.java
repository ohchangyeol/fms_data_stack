package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDeviceDisabilityHistoryId implements Serializable {
    private Timestamp disability_dt;
    private String error_code;
    private long vehicle_id;
}
