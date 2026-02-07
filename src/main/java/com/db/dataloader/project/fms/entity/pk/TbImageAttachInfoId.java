package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbImageAttachInfoId implements Serializable {
    private String attach_category_cd;
    private String file_id;
}
