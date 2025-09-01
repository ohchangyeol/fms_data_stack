package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbOpenapiApplicationServiceEnvironmentId implements Serializable {
    private long application_id;
    private long openapi_id;
    private long seq;
}
