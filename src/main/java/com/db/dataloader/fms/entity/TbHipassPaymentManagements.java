package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbHipassPaymentManagementsId;

@IdClass(TbHipassPaymentManagementsId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_hipass_payment_managements")
public class TbHipassPaymentManagements {
    @Id private String hipass_card_no;
    @Id private Timestamp transaction_dt;
    private long vehicle_id;
    private String entrance_toll_gate;
    private String exit_toll_gate;
    private long payment_amount;
    private String is_active;
    private Timestamp created_at;
    private String register_id;
    private Timestamp updated_at;
    private String storage_toll_gate;
    private String memo;
    private String updater_id;
}
