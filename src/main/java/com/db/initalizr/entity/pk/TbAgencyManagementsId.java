package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbAgencyManagementsId implements Serializable {
    private String agency_code;
    private long business_id;
}
