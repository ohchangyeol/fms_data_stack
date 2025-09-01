package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbOpenapiHistoriesId implements Serializable {
    private Timestamp created_at;
    private long history_id;
}
