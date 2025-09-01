package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbAppErrHistoriesId implements Serializable {
    private String imei;
    private Timestamp occurrence_dt;
}
