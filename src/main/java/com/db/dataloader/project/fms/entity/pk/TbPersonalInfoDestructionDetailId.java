package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPersonalInfoDestructionDetailId implements Serializable {
    private long destruction_no;
    private Timestamp occurrence_dt;
}
