package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_openapi_user_guide")
public class TbOpenapiUserGuide {
    @Id private long openapi_id;
    private String contents;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String register_id;
    private String updater_id;
}
