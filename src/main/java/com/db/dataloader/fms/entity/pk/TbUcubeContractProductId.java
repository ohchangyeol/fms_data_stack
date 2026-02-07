package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUcubeContractProductId implements Serializable {
    private String encnId;
    private String entrId;
    private String prodCd;
}
