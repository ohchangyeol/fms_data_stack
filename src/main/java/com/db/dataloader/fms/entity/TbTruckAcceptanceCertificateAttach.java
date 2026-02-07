package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_truck_acceptance_certificate_attach")
public class TbTruckAcceptanceCertificateAttach {
    @Id private String file_id;
    private long vehicle_id;
    private long seq;
    private long base_id;
    private Object schedule_start_time;
    private String is_loading;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
