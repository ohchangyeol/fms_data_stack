package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPremiumsId implements Serializable {
    private long seq;
    private long vehicle_id;
}
