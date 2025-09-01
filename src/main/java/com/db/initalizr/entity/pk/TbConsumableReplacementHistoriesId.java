package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbConsumableReplacementHistoriesId implements Serializable {
    private long consumable_id;
    private Date replacement_dt;
    private long vehicle_id;
}
