package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbBusOperationInfoId implements Serializable {
    private String bus_route_number;
    private long vehicle_id;
}
