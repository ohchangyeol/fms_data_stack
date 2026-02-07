package com.db.dataloader.rsc;

import java.util.List;

public class CommonConstant {
    public static final String SCHEMA_UFMSNEW = "INITUFMSNEW";
    public static final String SCHEMA_UFMSWD = "INITUFMSWD";
    public static final String SCHEMA_UFMSLOG = "INITUFMSLOG";

    public static final String TABLE_NAME = "%s.%s";
    public static final String UNION_ALL = "UNION ALL";


    public static final String COLUMN_TYPE = "TYPE_NAME";
    public static final String COLUMN_NAME = "COLUMN_NAME";
    public static final String IS_AUTOINCREMENT = "IS_AUTOINCREMENT";


    public static final String DATA_DUMMY = "DUMMY_DATA";
    public static final String DATA_POINT = "POINT (127.09966331720355 37.4121622775229)";
    public static final String DATA_CONTENT = "Terms and Conditions Dummy Data";


    public static final List<String> DATA_MBL_ENCN_STUS_CHG_CD = List.of("CAN","NAC","RSP","SUS","ZZ");
    public static final List<String> DATA_PROD_KD_CD = List.of("R","P");
}
