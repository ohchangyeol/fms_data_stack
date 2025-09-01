package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_menus")
public class TbMenus {
    @Id private String menu_id;
    private String menu_name;
    private long menu_level;
    private String program_id;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String parent_menu_id;
    private String updater_id;
}
