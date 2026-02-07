package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbBusBoardingInfoId implements Serializable {
    private String boarding_identification_number;
    private long vehicle_id;
}
