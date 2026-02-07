package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbSubscriptionServiceId;

@IdClass(TbSubscriptionServiceId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_subscription_service")
public class TbSubscriptionService {
    @Id private long business_id;
    @Id private String service_type_cd;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String register_id;
    private String updater_id;
}
