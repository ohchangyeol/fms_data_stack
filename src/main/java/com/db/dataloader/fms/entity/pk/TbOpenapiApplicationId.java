package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbOpenapiApplicationId implements Serializable {
    private long application_id;
    private long openapi_id;
}
