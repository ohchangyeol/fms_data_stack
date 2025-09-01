package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbSmsSendingMemberId implements Serializable {
    private long group_id;
    private long seq;
}
