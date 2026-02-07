package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbVehicleModelsByConsumablesId implements Serializable {
    private long consumable_id;
    private long vehicle_model_id;
}
