package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbBaseVehicleInfoId implements Serializable {
    private long base_id;
    private long vehicle_id;
}
