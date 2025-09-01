package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDirectInquiryAttachFileId implements Serializable {
    private String file_id;
    private long inquiry_id;
}
