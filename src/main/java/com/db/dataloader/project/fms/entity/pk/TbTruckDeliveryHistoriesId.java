package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTruckDeliveryHistoriesId implements Serializable {
    private long base_id;
    private Timestamp entry_dt;
    private long seq;
    private long vehicle_id;
}
