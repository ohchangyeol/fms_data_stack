package com.db.dataloader.project.fms.entity.pk;

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
