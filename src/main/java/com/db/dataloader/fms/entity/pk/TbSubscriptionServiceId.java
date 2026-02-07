package com.db.dataloader.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbSubscriptionServiceId implements Serializable {
    private long business_id;
    private String service_type_cd;
}
