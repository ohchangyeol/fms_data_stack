package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTruckOperationSetId implements Serializable {
    private long base_id;
    private long seq;
    private long vehicle_id;
}
