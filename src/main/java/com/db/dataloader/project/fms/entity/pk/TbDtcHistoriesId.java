package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDtcHistoriesId implements Serializable {
    private String dtc_code;
    private Timestamp occurrence_dt;
    private long vehicle_id;
}
