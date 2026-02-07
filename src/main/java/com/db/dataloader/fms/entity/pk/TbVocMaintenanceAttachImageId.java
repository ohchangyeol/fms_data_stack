package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbVocMaintenanceAttachImageId implements Serializable {
    private String file_id;
    private long maintenance_id;
}
