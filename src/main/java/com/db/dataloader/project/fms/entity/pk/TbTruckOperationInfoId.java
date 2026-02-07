package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTruckOperationInfoId implements Serializable {
    private long seq;
    private long vehicle_id;
}
