package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbUcubeContractProductId;

@IdClass(TbUcubeContractProductId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_ucube_contract_product")
public class TbUcubeContractProduct {
    @Id private String encnId;
    @Id private String entrId;
    @Id private String prodCd;
    private String prodKdCd;
    private Timestamp cntcProdStrtDttm;
    private Timestamp cntcProdEndDttm;
    private String svcSttsCd;
    private Timestamp createdAt;
    private String encnTlno;
}
