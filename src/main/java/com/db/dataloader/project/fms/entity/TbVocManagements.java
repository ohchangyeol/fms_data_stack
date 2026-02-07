package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbVocManagementsId;

@IdClass(TbVocManagementsId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_voc_managements")
public class TbVocManagements {
    @Id private long seq;
    @Id private String voc_identification_cd;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String manager_name;
    private String memo;
    private String register_id;
    private String model_no;
    private String vehicle_number;
    private String updater_id;
}
