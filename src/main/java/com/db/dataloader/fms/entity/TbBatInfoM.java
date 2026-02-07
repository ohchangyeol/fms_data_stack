package com.db.dataloader.fms.entity;

import jakarta.persistence.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_bat_info_m")
public class TbBatInfoM {
    @Id private String batch_id;
    private String batch_nm;
    private String batch_desc;
    private long exec_timeout;
    private String reg_usr_id;
    private String reg_dttm;
    private String server_chg_yn;
    private String mod_usr_id;
    private String mod_dttm;
}
