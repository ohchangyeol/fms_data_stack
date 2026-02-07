package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbAuthorityMenusId implements Serializable {
    private long authority_id;
    private long business_id;
    private String menu_id;
}
