package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbBatExeStatId implements Serializable {
    private String batch_id;
    private Date start_dttm;
}
