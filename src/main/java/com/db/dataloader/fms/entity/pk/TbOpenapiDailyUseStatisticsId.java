package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbOpenapiDailyUseStatisticsId implements Serializable {
    private long application_id;
    private long openapi_id;
    private Date statistics_dt;
}
