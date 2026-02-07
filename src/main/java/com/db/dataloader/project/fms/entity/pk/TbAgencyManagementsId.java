package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbAgencyManagementsId implements Serializable {
    private String agency_code;
    private long business_id;
}
