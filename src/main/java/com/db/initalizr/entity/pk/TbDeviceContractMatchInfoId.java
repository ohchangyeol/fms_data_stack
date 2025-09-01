package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDeviceContractMatchInfoId implements Serializable {
    private String model_no;
    private String serial_number;
}
