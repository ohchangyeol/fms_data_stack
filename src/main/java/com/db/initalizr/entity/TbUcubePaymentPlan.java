package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_ucube_payment_plan")
public class TbUcubePaymentPlan {
    @Id private String prodCd;
    private String prodName;
    private String prodKdCd;
    private Timestamp createdAt;
}
