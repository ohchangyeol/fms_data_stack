package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbUnmaskingReasonHistoriesId implements Serializable {
    private Timestamp created_at;
    private long reason_no;
}
