package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbBaseVehicleInfoId implements Serializable {
    private long base_id;
    private long vehicle_id;
}
