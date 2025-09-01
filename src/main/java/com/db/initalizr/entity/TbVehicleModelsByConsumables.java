package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbVehicleModelsByConsumablesId;

@IdClass(TbVehicleModelsByConsumablesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_vehicle_models_by_consumables")
public class TbVehicleModelsByConsumables {
    @Id private long consumable_id;
    @Id private long vehicle_model_id;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
