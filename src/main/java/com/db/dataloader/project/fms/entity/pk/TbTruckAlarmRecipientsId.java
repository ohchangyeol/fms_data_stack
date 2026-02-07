package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTruckAlarmRecipientsId implements Serializable {
    private String phone_number;
    private long vehicle_id;
}
