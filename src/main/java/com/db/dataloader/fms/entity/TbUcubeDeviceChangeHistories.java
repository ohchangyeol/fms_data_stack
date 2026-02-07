package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbUcubeDeviceChangeHistoriesId;

@IdClass(TbUcubeDeviceChangeHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_ucube_device_change_histories")
public class TbUcubeDeviceChangeHistories {
    @Id private Timestamp createdAt;
    @Id private String encnId;
    @Id private String entrId;
    @Id private String imeiIccidNo;
    private Timestamp cntcTrmStrtDttm;
    private String usimRuseYn;
    private String trmHistYn;
    private String changeTypeCd;
    private String trmSrno;
    private String bfrTrmSrno;
    private String trmMdlCd;
    private String bfrTrmMdlCd;
    private String mblTrmKdCd;
}
