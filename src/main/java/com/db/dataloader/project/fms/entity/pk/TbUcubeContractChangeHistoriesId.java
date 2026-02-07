package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUcubeContractChangeHistoriesId implements Serializable {
    private Timestamp createdAt;
    private String entrId;
}
