package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbMonthlyCostStatisticsId implements Serializable {
    private String cost_statistics_classification_cd;
    private String occurrence_month;
    private long vehicle_id;
}
