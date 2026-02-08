package com.db.dataloader.utils;

import com.db.dataloader.rsc.CommonConstant;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    public static String now() {
        return LocalDateTime.now().format(CommonConstant.FORMATTER_TS);
    }

    public static String elapsedHms(LocalDateTime start, LocalDateTime end) {
        long secs = Duration.between(start, end).getSeconds();
        long h = secs / 3600;
        long m = (secs % 3600) / 60;
        long s = secs % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public static String elapsedHms(long startMillis, long endMillis) {
        long secs = (endMillis - startMillis) / 1000;
        long h = secs / 3600;
        long m = (secs % 3600) / 60;
        long s = secs % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
