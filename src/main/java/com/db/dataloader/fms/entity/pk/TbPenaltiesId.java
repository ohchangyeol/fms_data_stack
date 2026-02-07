package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPenaltiesId implements Serializable {
    private Timestamp imposition_dt;
    private String reservation_number;
}
