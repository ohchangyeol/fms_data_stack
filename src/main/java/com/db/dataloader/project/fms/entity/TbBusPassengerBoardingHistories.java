package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbBusPassengerBoardingHistoriesId;

@IdClass(TbBusPassengerBoardingHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_bus_passenger_boarding_histories")
public class TbBusPassengerBoardingHistories {
    @Id private Timestamp arrived_dt;
    @Id private long base_id;
    @Id private String boarding_identification_number;
    @Id private String bus_route_number;
    @Id private long vehicle_id;
    private Timestamp created_at;
    private String register_id;
}
