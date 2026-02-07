package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbTruckAlarmRecipientsId;

@IdClass(TbTruckAlarmRecipientsId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_truck_alarm_recipients")
public class TbTruckAlarmRecipients {
    @Id private String phone_number;
    @Id private long vehicle_id;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
    private String memo;
}
