package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbOperationStatisticsId implements Serializable {
    private long business_id;
    private long business_place_number;
    private Date stat_dt;
    private long vehicle_id;
}
