package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbBusinessPlaceId implements Serializable {
    private long business_id;
    private long business_place_number;
}
