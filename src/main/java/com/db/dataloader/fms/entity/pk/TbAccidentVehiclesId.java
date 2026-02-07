package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbAccidentVehiclesId implements Serializable {
    private Timestamp accident_dt;
    private long vehicle_id;
}
