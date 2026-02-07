package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbFmsDeviceNumberId implements Serializable {
    private String fms_device_number;
    private String model_no;
    private long vehicle_id;
}
