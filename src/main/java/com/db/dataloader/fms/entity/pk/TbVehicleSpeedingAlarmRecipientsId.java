package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbVehicleSpeedingAlarmRecipientsId implements Serializable {
    private String phone_number;
    private long vehicle_id;
}
