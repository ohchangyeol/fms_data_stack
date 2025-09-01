package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbAdminMenusId implements Serializable {
    private String admin_no;
    private long authority_id;
    private String menu_id;
}
