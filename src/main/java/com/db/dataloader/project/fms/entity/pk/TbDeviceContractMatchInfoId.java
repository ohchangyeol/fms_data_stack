package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDeviceContractMatchInfoId implements Serializable {
    private String model_no;
    private String serial_number;
}
