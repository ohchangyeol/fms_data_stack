package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbVocManagementsId implements Serializable {
    private long seq;
    private String voc_identification_cd;
}
