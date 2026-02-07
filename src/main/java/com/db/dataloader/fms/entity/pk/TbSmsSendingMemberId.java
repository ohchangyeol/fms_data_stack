package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbSmsSendingMemberId implements Serializable {
    private long group_id;
    private long seq;
}
