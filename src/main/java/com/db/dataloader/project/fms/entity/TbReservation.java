package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbReservationId;

@IdClass(TbReservationId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_reservation")
public class TbReservation {
    @Id private String reservation_number;
    @Id private Timestamp start_time;
    private Timestamp end_time;
    private String rental_status;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String user_no;
    private long vehicle_id;
    private long passenger;
    private String is_before_taken_picture;
    private String is_after_taken_picture;
    private long hipass_fee;
    private long total_distance;
    private String purpose_cd;
    private String use_purpose;
    private String destination;
    private long cost_of_fuel;
    private String register_id;
    private long return_base_id;
    private String manager_process_time;
    private String team_leader_process_time;
    private String reason;
    private String parking_location_detail;
    private String manager_id;
    private String manager_comment;
    private String team_leader_id;
    private String team_leader_comment;
    private String fellow_passenger;
    private String assistant_driver_phone_number;
    private String memo;
    private Timestamp operating_start_time;
    private Timestamp operating_end_time;
    private long total_running_time;
    private String updater_id;
}
