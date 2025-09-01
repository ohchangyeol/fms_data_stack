package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbCostAttachFileId;

@IdClass(TbCostAttachFileId.class)
@Entity
@Table( schema = "ufmsnew", name = "tb_cost_attach_file")
public class TbCostAttachFile {
    @Id private long file_id;
    @Id private String file_name;
    @Id private String file_type;
    private String file_path;
    private String orgin_file_name;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
