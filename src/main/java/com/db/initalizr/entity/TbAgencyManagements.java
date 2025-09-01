package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbAgencyManagementsId;

@IdClass(TbAgencyManagementsId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_agency_managements")
public class TbAgencyManagements {
    @Id private String agency_code;
    @Id private long business_id;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
