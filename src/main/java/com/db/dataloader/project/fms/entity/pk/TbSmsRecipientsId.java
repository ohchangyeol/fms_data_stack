package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbSmsRecipientsId implements Serializable {
    private long manage_id;
    private long seq;
}
