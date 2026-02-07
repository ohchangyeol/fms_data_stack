package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTermConditionAgreementsId implements Serializable {
    private long seq;
    private long term_id;
    private long version;
}
