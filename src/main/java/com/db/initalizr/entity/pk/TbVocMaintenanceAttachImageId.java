package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbVocMaintenanceAttachImageId implements Serializable {
    private String file_id;
    private long maintenance_id;
}
