package com.db.dataloader.dx.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
public class ManualCreateSvc {
    private final EntityManager em;
    private final TransactionTemplate txTemplate;

    private static final DateTimeFormatter FORMATTER1 =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // timestamp(6) 포맷
    private static final DateTimeFormatter FORMATTER2 =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"); // timestamp(6) 포맷


    public void runManual() {

        String sql = """
                SELECT API_LOG_SEQ, API_LOG_DATE, ML_SERVER_NM, ML_MODEL_NM, ML_TYPE_CD, IOT_MODEL_NM, DEV_UUID, CTN, REQ_TIME, RES_TIME, REQ_DATA, RES_DATA, SUCC_YN, RESULT_CD
                FROM TB_AIGW_API_LOG PARTITION(P_202508);
                    """;
        List<Tuple> results = em.createNativeQuery(sql, Tuple.class).getResultList();

        int totalCount = 3600000 ;
        List<String> strings = List.of(
                "2025-09"
        );
        for (String st : strings){
            txTemplate.execute(status -> {
                // prosess(totalCount, results, st);
                prosess_v2(totalCount, results, st);
                return null;
            });
        }


    }

    private void prosess(int totalCount, List<Tuple> results , String partition) {
        Iterable<String> dates = splitMonthIterable(partition, totalCount);

        System.out.println("");

        int batchSize = 1000;
        StringBuilder insertSql = new StringBuilder();
        int count = 0, total = 0;
        String insertPrefix = """
                INSERT IGNORE INTO iiot_sf.tb_aigw_api_log
                (API_LOG_DATE, ML_SERVER_NM, ML_MODEL_NM, ML_TYPE_CD, IOT_MODEL_NM, DEV_UUID, CTN, REQ_TIME, RES_TIME, REQ_DATA, RES_DATA, SUCC_YN, RESULT_CD)
                VALUES
            """;

        Iterator<String> dateIterator = dates.iterator();
        Random rng = new Random();
        for (int i = 0; i < totalCount; i++) {
            if (count == 0) {
                insertSql.setLength(0);
                insertSql.append(insertPrefix);
            }
            String date = dateIterator.next();
            Tuple t = results.get(rng.nextInt(results.size()));
            insertSql.append("(")
                    .append(toSql(date)).append(",")
                    .append(toSql(t.get("ML_SERVER_NM"))).append(",")
                    .append(toSql(t.get("ML_MODEL_NM"))).append(",")
                    .append(toSql(t.get("ML_TYPE_CD"))).append(",")
                    .append(toSql(t.get("IOT_MODEL_NM"))).append(",")
                    .append(toSql(t.get("DEV_UUID"))).append(",")
                    .append(toSql(t.get("CTN"))).append(",")
                    .append(toSql(date)).append(",")
                    .append(toSql(date)).append(",")
                    .append(toSql(t.get("REQ_DATA"))).append(",")
                    .append(toSql(t.get("RES_DATA"))).append(",")
                    .append(toSql(t.get("SUCC_YN"))).append(",")
                    .append(toSql(t.get("RESULT_CD")))
                    .append(")");
            count++;

            boolean last = (i == totalCount - 1);

            if (count == batchSize || last) {
                int i1 = em.createNativeQuery(insertSql.toString()).executeUpdate();
                em.flush();
                em.clear();
                count = 0;
                total+= i1;
                System.out.println(total);
            } else {
                insertSql.append(",");
            }

        }
    }

    private void prosess_v2(int totalCount, List<Tuple> results, String partition) {
        Iterable<String> dates = splitMonthIterable(partition, totalCount);

        int batchSize = 1000;
        AtomicInteger total = new AtomicInteger();
        String insertSql = """
                INSERT IGNORE INTO iiot_sf.tb_aigw_api_log
                (API_LOG_DATE, ML_SERVER_NM, ML_MODEL_NM, ML_TYPE_CD, IOT_MODEL_NM, DEV_UUID, CTN, REQ_TIME, RES_TIME, REQ_DATA, RES_DATA, SUCC_YN, RESULT_CD)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;

        Iterator<String> dateIterator = dates.iterator();
        Random rng = new Random();

        Session session = em.unwrap(Session.class);
        session.doWork(conn -> {
            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                int count = 0;
                for (int i = 0; i < totalCount; i++) {
                    String date = dateIterator.next();
                    Tuple t = results.get(rng.nextInt(results.size()));

                    int idx = 1;
                    setParam(ps, idx++, date);
                    setParam(ps, idx++, t.get("ML_SERVER_NM"));
                    setParam(ps, idx++, t.get("ML_MODEL_NM"));
                    setParam(ps, idx++, t.get("ML_TYPE_CD"));
                    setParam(ps, idx++, t.get("IOT_MODEL_NM"));
                    setParam(ps, idx++, t.get("DEV_UUID"));
                    setParam(ps, idx++, t.get("CTN"));
                    setParam(ps, idx++, date);
                    setParam(ps, idx++, date);
                    setParam(ps, idx++, t.get("REQ_DATA"));
                    setParam(ps, idx++, t.get("RES_DATA"));
                    setParam(ps, idx++, t.get("SUCC_YN"));
                    setParam(ps, idx++, t.get("RESULT_CD"));

                    ps.addBatch();
                    count++;

                    boolean last = (i == totalCount - 1);
                    if (count == batchSize || last) {
                        ps.executeBatch();
                        total.addAndGet(count);
                        count = 0;
                        System.out.println(total.get());
                    }
                }
            }
        });
    }

    private String stringDate(String input) {
        DateTimeFormatter inFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter outFmt = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return LocalDateTime.parse(input, inFmt).format(outFmt);
    }

    private String monthDate(String input) {
        DateTimeFormatter inFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter outFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.parse(input, inFmt).format(outFmt);
    }

    private String toSql(Object v) {
        if (v == null) return "null";
        return "'" + v.toString().replace("'", "''") + "'";
    }

    private void setParam(PreparedStatement ps, int index, Object value) throws SQLException {
        if (value == null) {
            ps.setNull(index, Types.VARCHAR);
            return;
        }
        if (value instanceof String s) {
            ps.setString(index, s);
            return;
        }
        ps.setObject(index, value);
    }

    private Iterable<String> splitMonthIterable(String yearMonth, int totalCount) {
        int year = Integer.parseInt(yearMonth.substring(0, 4));
        int month = Integer.parseInt(yearMonth.substring(5, 7));

        LocalDate startDate = LocalDate.of(year, month, 1);
        int daysInMonth = startDate.lengthOfMonth();
        long totalSeconds = daysInMonth * 24L * 60L * 60L;
        long totalNanos = totalSeconds * 1_000_000_000L;
        long base = totalNanos / totalCount;
        long remainder = totalNanos % totalCount;

        LocalDateTime start = startDate.atStartOfDay();

        return () -> new Iterator<String>() {
            private long index = 0;

            @Override
            public boolean hasNext() {
                return index < totalCount;
            }

            @Override
            public String next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                long offset = (index * base) + Math.min(index, remainder);
                LocalDateTime timestamp = start.plusNanos(offset);
                index++;
                return timestamp.format(FORMATTER2);
            }
        };
    }
}
