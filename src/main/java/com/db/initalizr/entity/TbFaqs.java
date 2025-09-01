package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbFaqsId;

@IdClass(TbFaqsId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_faqs")
public class TbFaqs {
    @Id private String category_cd;
    @Id private long seq;
    private String title;
    private String content;
    private String is_top10;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
