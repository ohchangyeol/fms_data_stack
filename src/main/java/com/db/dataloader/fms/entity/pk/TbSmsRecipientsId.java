package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbSmsRecipientsId implements Serializable {
    private long manage_id;
    private long seq;
}
