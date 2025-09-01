package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbSmsSendingHistoriesId implements Serializable {
    private long history_no;
    private Timestamp sending_dt;
}
