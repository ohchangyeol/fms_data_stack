package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUcubeDeviceChangeHistoriesId implements Serializable {
    private Timestamp createdAt;
    private String encnId;
    private String entrId;
    private String imeiIccidNo;
}
