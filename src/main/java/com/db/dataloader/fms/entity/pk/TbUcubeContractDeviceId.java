package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUcubeContractDeviceId implements Serializable {
    private String encnId;
    private String entrId;
    private String imeiIccidNo;
}
