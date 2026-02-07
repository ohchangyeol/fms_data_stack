package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbFinesId implements Serializable {
    private String user_no;
    private Timestamp violation_dt;
}
