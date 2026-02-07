package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbVehicleSpeedingAlarmRecipientsId;

@IdClass(TbVehicleSpeedingAlarmRecipientsId.class)
@Entity
@Table( schema = "ufmsnew", name = "tb_vehicle_speeding_alarm_recipients")
public class TbVehicleSpeedingAlarmRecipients {
    @Id private String phone_number;
    @Id private long vehicle_id;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
    private String memo;
}
