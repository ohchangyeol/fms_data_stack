package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_ucube_contract")
public class TbUcubeContract {
    @Id private String entrId;
    private String encnId;
    private Timestamp encnDttm;
    private Timestamp createdAt;
    private String encnTlno;
    private String atrcDealCd;
    private String mblEncnStusChgCd;
}
