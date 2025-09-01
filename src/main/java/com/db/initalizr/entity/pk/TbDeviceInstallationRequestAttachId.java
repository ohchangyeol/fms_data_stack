package com.db.initalizr.entity.pk;

import lombok.*;

import java.io.Serializable;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDeviceInstallationRequestAttachId implements Serializable {
    private String contract_id;
    private String file_id;
    private String subscription_id;
}
