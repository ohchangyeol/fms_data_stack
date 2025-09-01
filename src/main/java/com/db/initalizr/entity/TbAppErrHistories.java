package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbAppErrHistoriesId;

@IdClass(TbAppErrHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_app_err_histories")
public class TbAppErrHistories {
    @Id private String imei;
    @Id private Timestamp occurrence_dt;
    private String err_code;
    private String err_msg;
}
