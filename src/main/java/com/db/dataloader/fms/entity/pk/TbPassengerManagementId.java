package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPassengerManagementId implements Serializable {
    private String passenger_no;
    private long vehicle_id;
}
