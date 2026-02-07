package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPersonalInfoProvided3rdpartyId implements Serializable {
    private Timestamp created_at;
    private long provided_no;
}
