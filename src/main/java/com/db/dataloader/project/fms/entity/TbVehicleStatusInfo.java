package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_vehicle_status_info")
public class TbVehicleStatusInfo {
    @Id private long vehicle_id;
    private String imei;
    private Timestamp created_at;
    private String firmware_version;
    private long boot_cause_major;
    private String boot_cause_minor;
    private String device_voltage;
    private String peripheral_status;
    private String key_state;
    private String is_front_left_door_open;
    private String is_front_right_door_open;
    private String is_rear_left_door_open;
    private String is_rear_right_door_open;
    private double odometer;
    private Object fuel_level;
    private Object rpm;
    private Object velocity;
    private String is_charger_detection;
    private String is_charging_complete;
    private String charging_voltage;
    private String charging_current;
    private Object battery_temperature;
    private Object tpms_fl;
    private Object tpms_fr;
    private Object tpms_rl;
    private Object tpms_rr;
    private long idling_seconds;
    private String longitude;
    private String latitude;
    private String is_non_escape_violation;
    private String is_entry_prohibited_violation;
    private Object soc;
    private Object soh;
    private String door_open_status;
    private long front_temperature;
    private long back_temperature;
    private String is_temperature_abnormal;
}
