package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbAuthorityMenusBakId implements Serializable {
    private long authority_id;
    private long business_id;
    private String menu_id;
}
