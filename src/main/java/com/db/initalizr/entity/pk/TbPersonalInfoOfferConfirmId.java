package com.db.initalizr.entity.pk;

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
