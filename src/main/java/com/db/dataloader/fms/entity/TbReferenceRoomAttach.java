package com.db.dataloader.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

import com.db.dataloader.fms.entity.pk.TbReferenceRoomAttachId;

@IdClass(TbReferenceRoomAttachId.class)
@Entity
@Table( schema = "INITUFMSNEW", name = "tb_reference_room_attach")
public class TbReferenceRoomAttach {
    @Id private String file_id;
    @Id private long reference_id;
    private String is_active;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String register_id;
    private String updater_id;
}
