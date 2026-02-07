package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbImageAttachInfoId;

@IdClass(TbImageAttachInfoId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_image_attach_info")
public class TbImageAttachInfo {
    @Id private String attach_category_cd;
    @Id private String file_id;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String reservation_number;
    private long vehicle_id;
    private String updater_id;
}
