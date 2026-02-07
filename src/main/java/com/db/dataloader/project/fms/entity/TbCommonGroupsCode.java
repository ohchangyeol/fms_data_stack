package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbCommonGroupsCodeId;

@IdClass(TbCommonGroupsCodeId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_common_groups_code")
public class TbCommonGroupsCode {
    @Id private String common_code;
    @Id private String common_identification_cd;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String common_code_name;
    private String register_id;
    private long sort_order;
    private String contents;
    private String updater_id;
}
