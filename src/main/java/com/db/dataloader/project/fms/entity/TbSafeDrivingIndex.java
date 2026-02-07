package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_safe_driving_index")
public class TbSafeDrivingIndex {
    @Id private String safe_driving_index_cd;
    private long point;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String register_id;
    private String updater_id;
}
