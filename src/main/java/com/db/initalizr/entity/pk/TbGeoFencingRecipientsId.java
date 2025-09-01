package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbGeoFencingRecipientsId implements Serializable {
    private long geo_fencing_id;
    private String phone_number;
}
