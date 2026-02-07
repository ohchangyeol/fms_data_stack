package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbVocManagementsId implements Serializable {
    private long seq;
    private String voc_identification_cd;
}
