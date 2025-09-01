package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbAuthorityMenusBakId implements Serializable {
    private long authority_id;
    private long business_id;
    private String menu_id;
}
