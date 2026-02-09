package com.db.dataloader.rsc;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class CommonConstant {

    public static final DateTimeFormatter FORMATTER_TS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter FORMATTER_TS3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    public static final DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter FORMATTER_YMDHMS = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter FORMATTER_YMDHMS3 = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    public static final DateTimeFormatter FORMATTER_YMD = DateTimeFormatter.ofPattern("yyyyMMdd");

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

    // DX
    public static final String COLUMN_TS = "ts";
    public static final String COLUMN_TS3 = "ts3";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_YMDHMS = "ymdhms";
    public static final String COLUMN_YMDHMS3 = "ymdhms3";
    public static final String COLUMN_YMD = "ymd";
    public static final String COLUMN_AUTO = "auto";

}
