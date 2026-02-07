package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.project.fms.entity.pk.TbUcubeContractChangeHistoriesId;

@IdClass(TbUcubeContractChangeHistoriesId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_ucube_contract_change_histories")
public class TbUcubeContractChangeHistories {
    @Id private Timestamp createdAt;
    @Id private String entrId;
    private String encnId;
    private Timestamp encnStusChgDttm;
    private String bfrEncnId;
    private String mblEncnStusChgCd;
    private String atrcDealCd;
    private String changeTypeCd;
}
