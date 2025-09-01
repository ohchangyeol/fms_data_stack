package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTruckOptionSetId implements Serializable {
    private String truck_option_cd;
    private long vehicle_id;
}
