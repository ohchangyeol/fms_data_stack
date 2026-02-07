package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDeviceInstallationRequestAttachId implements Serializable {
    private String contract_id;
    private String file_id;
    private String subscription_id;
}
