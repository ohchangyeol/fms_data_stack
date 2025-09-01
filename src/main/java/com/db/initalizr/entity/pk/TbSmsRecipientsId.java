package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbSmsRecipientsId implements Serializable {
    private long manage_id;
    private long seq;
}
