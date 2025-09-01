package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbVehicleModelsByConsumablesId implements Serializable {
    private long consumable_id;
    private long vehicle_model_id;
}
