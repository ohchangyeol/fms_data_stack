package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUcubeProductChangeHistoriesId implements Serializable {
    private Timestamp createdAt;
    private String encnId;
    private String entrId;
    private String prodCd;
}
