package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbVocMaintenanceAttachImageId;

@IdClass(TbVocMaintenanceAttachImageId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_voc_maintenance_attach_image")
public class TbVocMaintenanceAttachImage {
    @Id private String file_id;
    @Id private long maintenance_id;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
