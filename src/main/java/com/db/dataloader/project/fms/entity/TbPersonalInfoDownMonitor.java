package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbPersonalInfoDownMonitorId;

@IdClass(TbPersonalInfoDownMonitorId.class)
@Entity
@Table( schema = "INITUFMSWD", name = "tb_personal_info_down_monitor")
public class TbPersonalInfoDownMonitor {
    @Id private Timestamp created_at;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long monitor_no;
    private String view_user_no;
    private String connection_point;
    private String offer_user_no;
    private String tasks_performed;
    private String register_id;
    private String download_reason;
}
