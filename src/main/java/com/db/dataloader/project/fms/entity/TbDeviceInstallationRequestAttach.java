package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbDeviceInstallationRequestAttachId;

@IdClass(TbDeviceInstallationRequestAttachId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_device_installation_request_attach")
public class TbDeviceInstallationRequestAttach {
    @Id private String contract_id;
    @Id private String file_id;
    @Id private String subscription_id;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
