package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbBusinessPlaceId;

@IdClass(TbBusinessPlaceId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_business_place")
public class TbBusinessPlace {
    @Id private long business_id;
    @Id private long business_place_number;
    private String business_place_name;
    private String address;
    private String address_detail;
    private String post_cd;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String register_id;
    private String updater_id;
}
