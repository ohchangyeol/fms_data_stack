package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbPersonalInfoDestructionDetailId;

@IdClass(TbPersonalInfoDestructionDetailId.class)
@Entity
@Table( schema = "INITUFMSWD", name = "tb_personal_info_destruction_detail")
public class TbPersonalInfoDestructionDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long destruction_no;
    @Id private Timestamp occurrence_dt;
    private String data_type;
    private Timestamp deletion_dt;
    private String disposal_reason;
    private Timestamp created_at;
    private String register_id;
}
