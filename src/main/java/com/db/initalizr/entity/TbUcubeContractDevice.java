package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbUcubeContractDeviceId;

@IdClass(TbUcubeContractDeviceId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_ucube_contract_device")
public class TbUcubeContractDevice {
    @Id private String encnId;
    @Id private String entrId;
    @Id private String imeiIccidNo;
    private String trmNo;
    private Timestamp cntcTrmStrtDttm;
    private Timestamp createdAt;
    private String trmMdlCd;
    private String mblTrmKdCd;
    private String rsalPosCd;
}
