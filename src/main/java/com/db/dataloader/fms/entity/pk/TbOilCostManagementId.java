package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbOilCostManagementId implements Serializable {
    private Timestamp refueling_dt;
    private long vehicle_id;
}
