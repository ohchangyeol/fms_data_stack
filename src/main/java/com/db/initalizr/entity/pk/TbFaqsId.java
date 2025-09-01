package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbFaqsId implements Serializable {
    private String category_cd;
    private long seq;
}
