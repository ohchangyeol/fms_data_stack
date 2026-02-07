package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDirectInquiryAttachFileId implements Serializable {
    private String file_id;
    private long inquiry_id;
}
