package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPassengerManagementId implements Serializable {
    private String passenger_no;
    private long vehicle_id;
}
