package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbOilCostManagementBakId implements Serializable {
    private Timestamp refueling_dt;
    private long vehicle_id;
}
