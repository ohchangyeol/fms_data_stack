package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbReferenceRoomAttachId implements Serializable {
    private String file_id;
    private long reference_id;
}
