package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbCommonGroupsCodeId implements Serializable {
    private String common_code;
    private String common_identification_cd;
}
