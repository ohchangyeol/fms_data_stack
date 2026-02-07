package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_program_file_names")
public class TbProgramFileNames {
    @Id private String file_id;
    private String is_image;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String orginal_file_name;
    private String attach_file_name;
    private long file_size;
    private String register_id;
    private String updater_id;
}
