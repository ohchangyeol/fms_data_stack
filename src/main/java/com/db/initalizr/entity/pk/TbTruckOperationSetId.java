package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTruckOperationSetId implements Serializable {
    private long base_id;
    private long seq;
    private long vehicle_id;
}
