package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbSubscriptionServiceId implements Serializable {
    private long business_id;
    private String service_type_cd;
}
