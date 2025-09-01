package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbCostAttachFileId implements Serializable {
    private long file_id;
    private String file_name;
    private String file_type;
}
