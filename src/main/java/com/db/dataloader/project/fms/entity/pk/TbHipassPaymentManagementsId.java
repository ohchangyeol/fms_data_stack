package com.db.dataloader.project.fms.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbHipassPaymentManagementsId implements Serializable {
    private String hipass_card_no;
    private Timestamp transaction_dt;
}
