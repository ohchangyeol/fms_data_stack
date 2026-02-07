package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPersonalInfoviewHistoriesId implements Serializable {
    private long history_no;
    private Timestamp search_target_dt;
}
