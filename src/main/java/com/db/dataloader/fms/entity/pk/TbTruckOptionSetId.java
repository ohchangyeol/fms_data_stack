package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTruckOptionSetId implements Serializable {
    private String truck_option_cd;
    private long vehicle_id;
}
