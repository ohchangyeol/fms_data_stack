package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbUcubeProductChangeHistoriesId;

@IdClass(TbUcubeProductChangeHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_ucube_product_change_histories")
public class TbUcubeProductChangeHistories {
    @Id private Timestamp createdAt;
    @Id private String encnId;
    @Id private String entrId;
    @Id private String prodCd;
    private String prodKdCd;
    private Timestamp cntcProdStrtDttm;
    private Timestamp cntcProdEndDttm;
    private String svcSttsCd;
    private String changeTypeCd;
    private String encnTlno;
}
