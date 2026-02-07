package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDailyRentalStatisticsId implements Serializable {
    private long business_id;
    private String rental_status;
    private Date statistics_dt;
}
