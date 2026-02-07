package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_common_groups")
public class TbCommonGroups {
    @Id private String common_identification_cd;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String common_category_name;
    private String register_id;
    private String contents;
    private String updater_id;
}
