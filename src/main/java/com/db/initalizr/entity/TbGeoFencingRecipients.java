package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbGeoFencingRecipientsId;

@IdClass(TbGeoFencingRecipientsId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_geo_fencing_recipients")
public class TbGeoFencingRecipients {
    @Id private long geo_fencing_id;
    @Id private String phone_number;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
    private String memo;
}
