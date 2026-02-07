package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbSmsSendingMemberId implements Serializable {
    private long group_id;
    private long seq;
}
