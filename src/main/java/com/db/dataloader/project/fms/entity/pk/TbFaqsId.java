package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbFaqsId implements Serializable {
    private String category_cd;
    private long seq;
}
