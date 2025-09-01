package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUcubeContractProductId implements Serializable {
    private String encnId;
    private String entrId;
    private String prodCd;
}
