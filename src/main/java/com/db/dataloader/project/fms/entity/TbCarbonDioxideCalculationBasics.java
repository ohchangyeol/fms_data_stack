package com.db.dataloader.project.fms.entity;

import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table( schema = "INITUFMSNEW", name = "tb_carbon_dioxide_calculation_basics")
public class TbCarbonDioxideCalculationBasics {
    @Id private String fuel_classification_cd;
    private String unit;
    private long total_heat_quantity;
    private long pure_heat_quantity;
    private long carbon_dioxide_value;
    private long index_val;
    private Timestamp created_at;
    private String register_id;
}
