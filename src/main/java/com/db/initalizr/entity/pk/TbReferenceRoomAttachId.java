package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbReferenceRoomAttachId implements Serializable {
    private String file_id;
    private long reference_id;
}
