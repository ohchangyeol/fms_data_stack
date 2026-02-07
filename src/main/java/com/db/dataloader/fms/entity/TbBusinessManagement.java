package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "ufmsnew", name = "tb_business_management")
public class TbBusinessManagement {
    @Id private long business_id;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
    private long over_speed_limit;
    private String work_start_time;
    private String work_end_time;
}
