package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPersonalInfoViewConfirmId implements Serializable {
    private Timestamp view_dt;
    private long view_no;
}
