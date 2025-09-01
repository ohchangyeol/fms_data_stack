package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbAdminMenusId;

@IdClass(TbAdminMenusId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_admin_menus")
public class TbAdminMenus {
    @Id private String admin_no;
    @Id private long authority_id;
    @Id private String menu_id;
    private long sort_order;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private long business_place_number;
    private String updater_id;
}
