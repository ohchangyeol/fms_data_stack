package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbOpenapiApplicationServiceEnvironmentId implements Serializable {
    private long application_id;
    private long openapi_id;
    private long seq;
}
