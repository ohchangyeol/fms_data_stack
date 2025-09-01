package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbBusBoardingInfoId implements Serializable {
    private String boarding_identification_number;
    private long vehicle_id;
}
