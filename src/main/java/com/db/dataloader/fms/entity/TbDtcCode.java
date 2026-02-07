package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_dtc_code")
public class TbDtcCode {
    @Id private String dtc_code;
    private String dtc_name;
    private Timestamp created_at;
    private String register_id;
}
