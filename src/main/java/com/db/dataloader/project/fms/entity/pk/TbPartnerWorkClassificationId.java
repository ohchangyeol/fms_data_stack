package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPartnerWorkClassificationId implements Serializable {
    private long business_id;
    private String work_classification_cd;
}
