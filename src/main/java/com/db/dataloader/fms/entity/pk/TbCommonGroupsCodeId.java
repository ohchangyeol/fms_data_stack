package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbCommonGroupsCodeId implements Serializable {
    private String common_code;
    private String common_identification_cd;
}
