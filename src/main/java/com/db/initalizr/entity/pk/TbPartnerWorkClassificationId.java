package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPartnerWorkClassificationId implements Serializable {
    private long business_id;
    private String work_classification_cd;
}
