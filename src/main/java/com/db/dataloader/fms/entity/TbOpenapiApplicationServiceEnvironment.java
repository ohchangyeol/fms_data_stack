package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbOpenapiApplicationServiceEnvironmentId;

@IdClass(TbOpenapiApplicationServiceEnvironmentId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_openapi_application_service_environment")
public class TbOpenapiApplicationServiceEnvironment {
    @Id private long application_id;
    @Id private long openapi_id;
    @Id private long seq;
    private String service_environment_type_cd;
    private String url;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String register_id;
    private String updater_id;
}
