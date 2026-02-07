package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbBusinessPlaceId implements Serializable {
    private long business_id;
    private long business_place_number;
}
