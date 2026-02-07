package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbBusPassengerBoardingHistoriesId implements Serializable {
    private Timestamp arrived_dt;
    private long base_id;
    private String boarding_identification_number;
    private String bus_route_number;
    private long vehicle_id;
}
