package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbGeoFencingRecipientsId implements Serializable {
    private long geo_fencing_id;
    private String phone_number;
}
