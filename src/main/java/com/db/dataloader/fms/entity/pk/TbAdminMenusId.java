package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbAdminMenusId implements Serializable {
    private String admin_no;
    private long authority_id;
    private String menu_id;
}
