package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbAdminUsersHistoriesId implements Serializable {
    private String admin_no;
    private Timestamp created_at;
}
