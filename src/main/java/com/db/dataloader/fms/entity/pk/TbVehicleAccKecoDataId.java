package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbVehicleAccKecoDataId implements Serializable {
    private long event_no;
    private Timestamp send_dt;
    private long vehicle_id;
}
