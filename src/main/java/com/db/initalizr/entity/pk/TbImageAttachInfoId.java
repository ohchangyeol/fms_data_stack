package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbImageAttachInfoId implements Serializable {
    private String attach_category_cd;
    private String file_id;
}
