package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbCostAttachFileId implements Serializable {
    private long file_id;
    private String file_name;
    private String file_type;
}
