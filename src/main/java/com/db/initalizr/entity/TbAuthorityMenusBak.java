package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbAuthorityMenusBakId;

@IdClass(TbAuthorityMenusBakId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_authority_menus_bak")
public class TbAuthorityMenusBak {
    @Id private long authority_id;
    @Id private long business_id;
    @Id private String menu_id;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private long business_place_number;
    private String updater_id;
}
