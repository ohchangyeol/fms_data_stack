package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbTermConditionAgreementsId;

@IdClass(TbTermConditionAgreementsId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_term_condition_agreements")
public class TbTermConditionAgreements {
    @Id private long seq;
    @Id private long term_id;
    @Id private long version;
    private String agree_category_cd;
    private String is_agreement;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String user_no;
    private String admin_no;
    private String updater_id;
}
