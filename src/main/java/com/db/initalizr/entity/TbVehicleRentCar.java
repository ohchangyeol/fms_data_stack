package com.db.initalizr.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_vehicle_rent_car")
public class TbVehicleRentCar {
    @Id private long vehicle_id;
    private long seats;
    private String color_classification_cd;
    private Date rent_start_date;
    private Date rent_end_date;
    private String rent_use_classification_cd;
    private Date insurance_start_date;
    private Date insurance_end_date;
    private String is_vehicle_availability;
    private String is_active;
    private Timestamp created_at;
    private String created_id;
    private Timestamp updated_at;
    private String insurance_company;
    private String updater_id;
}
