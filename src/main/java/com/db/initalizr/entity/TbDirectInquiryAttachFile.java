package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.initalizr.entity.pk.TbDirectInquiryAttachFileId;

@IdClass(TbDirectInquiryAttachFileId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_direct_inquiry_attach_file")
public class TbDirectInquiryAttachFile {
    @Id private String file_id;
    @Id private long inquiry_id;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String updater_id;
}
