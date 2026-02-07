package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbReservationId implements Serializable {
    private String reservation_number;
    private Timestamp start_time;
}
