package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPersonalInfoOfferConfirmId implements Serializable {
    private Timestamp offer_dt;
    private long offer_no;
}
