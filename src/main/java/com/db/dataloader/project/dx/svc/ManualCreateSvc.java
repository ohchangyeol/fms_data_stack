package com.db.dataloader.project.dx.svc;

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
                SELECT CTL_DATE, CTL_SEQ, ENTR_DEV_SEQ, CUST_SEQ, SVC_CD, DEV_CLS_CD, DEV_MDL_CD, RES_DATE, ENTR_NO, CTN, ENTITY_ID, DEV_ATTR_CD_ID, PAM_KEY, DEV_VAL, CUR_DEV_VAL, CTL_TYPE, PRC_CD, RETRY_CNT, DEV_TIME, REG_USR_ID, REG_DTTM, MOD_USR_ID, MOD_DTTM
                FROM iiot_sf.tb_iot_ctl_hist PARTITION(P_202602)
                    """;
        List<Tuple> results = em.createNativeQuery(sql, Tuple.class).getResultList();

        int totalCount = 126300 ;
        List<String> strings = List.of(
                "2025-09",
                "2025-10",
                "2025-11",
                "2025-12",
                "2026-01"
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

        int batchSize = 1000;
        StringBuilder insertSql = new StringBuilder();
        int count = 0, total = 0;
        String insertPrefix = """
                INSERT IGNORE INTO iiot_sf.TB_IOT_CTL_HIST
                (CTL_DATE, CTL_SEQ, ENTR_DEV_SEQ, CUST_SEQ, SVC_CD, DEV_CLS_CD, DEV_MDL_CD, RES_DATE, ENTR_NO, CTN, ENTITY_ID, DEV_ATTR_CD_ID, PAM_KEY, DEV_VAL, CUR_DEV_VAL, CTL_TYPE, PRC_CD, RETRY_CNT, DEV_TIME, REG_USR_ID, REG_DTTM, MOD_USR_ID, MOD_DTTM)
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
                    .append(toSql(t.get("ENTR_DEV_SEQ"))).append(",")
                    .append(toSql(t.get("CUST_SEQ"))).append(",")
                    .append(toSql(t.get("SVC_CD"))).append(",")
                    .append(toSql(t.get("DEV_CLS_CD"))).append(",")
                    .append(toSql(t.get("DEV_MDL_CD"))).append(",")
                    .append(toSql(date)).append(",")
                    .append(toSql(t.get("ENTR_NO"))).append(",")
                    .append(toSql(t.get("CTN"))).append(",")
                    .append(toSql(t.get("ENTITY_ID"))).append(",")
                    .append(toSql(t.get("DEV_ATTR_CD_ID"))).append(",")
                    .append(toSql(t.get("PAM_KEY"))).append(",")
                    .append(toSql(t.get("DEV_VAL"))).append(",")
                    .append(toSql(t.get("CUR_DEV_VAL"))).append(",")
                    .append(toSql(t.get("CTL_TYPE"))).append(",")
                    .append(toSql(t.get("PRC_CD"))).append(",")
                    .append(toSql(t.get("RETRY_CNT"))).append(",")
                    .append(toSql(t.get("DEV_TIME"))).append(",")
                    .append(toSql(t.get("REG_USR_ID"))).append(",")
                    .append(toSql(stringDate(date))).append(",")
                    .append(toSql(t.get("MOD_USR_ID"))).append(",")
                    .append(toSql(t.get("MOD_DTTM")))
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
                INSERT INTO iiot_sf.tb_iot_ctl_hist
                (CTL_DATE, ENTR_DEV_SEQ, CUST_SEQ, SVC_CD, DEV_CLS_CD, DEV_MDL_CD, RES_DATE, ENTR_NO, CTN, ENTITY_ID, DEV_ATTR_CD_ID, PAM_KEY, DEV_VAL, CUR_DEV_VAL, CTL_TYPE, PRC_CD, RETRY_CNT, DEV_TIME, REG_USR_ID, REG_DTTM, MOD_USR_ID, MOD_DTTM)
                VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
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
                    setParam(ps, idx++, t.get("ENTR_DEV_SEQ"));
                    setParam(ps, idx++, t.get("CUST_SEQ"));
                    setParam(ps, idx++, t.get("SVC_CD"));
                    setParam(ps, idx++, t.get("DEV_CLS_CD"));
                    setParam(ps, idx++, t.get("DEV_MDL_CD"));
                    setParam(ps, idx++, date);
                    setParam(ps, idx++, t.get("ENTR_NO"));
                    setParam(ps, idx++, t.get("CTN"));
                    setParam(ps, idx++, t.get("ENTITY_ID"));
                    setParam(ps, idx++, t.get("DEV_ATTR_CD_ID"));
                    setParam(ps, idx++, t.get("PAM_KEY"));
                    setParam(ps, idx++, t.get("DEV_VAL"));
                    setParam(ps, idx++, t.get("CUR_DEV_VAL"));
                    setParam(ps, idx++, t.get("CTL_TYPE"));
                    setParam(ps, idx++, t.get("PRC_CD"));
                    setParam(ps, idx++, t.get("RETRY_CNT"));
                    setParam(ps, idx++, t.get("DEV_TIME"));
                    setParam(ps, idx++, t.get("REG_USR_ID"));
                    setParam(ps, idx++, stringDate(date));
                    setParam(ps, idx++, t.get("MOD_USR_ID"));
                    setParam(ps, idx++, t.get("MOD_DTTM"));

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
                return timestamp.format(FORMATTER1);
            }
        };
    }
}
