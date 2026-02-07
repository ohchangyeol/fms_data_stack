package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbBatExeStatId;

@IdClass(TbBatExeStatId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_bat_exe_stat")
public class TbBatExeStat {
    @Id private String batch_id;
    @Id private Date start_dttm;
    private Date stop_dttm;
    private String server_nm;
    private String result_desc;
    private long succ_cnt;
    private long fail_cnt;
    private String reg_usr_id;
    private String reg_dttm;
    private String result_yn;
    private Date exec_dttm;
    private String mod_usr_id;
    private String mod_dttm;
}
