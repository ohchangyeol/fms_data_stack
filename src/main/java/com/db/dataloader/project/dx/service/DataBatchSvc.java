package com.db.dataloader.project.dx.service;

import com.db.dataloader.project.dx.dto.TableInfoDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
@RequiredArgsConstructor
public class DataBatchSvc {
    private final EntityManager em;

    private static final DateTimeFormatter TS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter TS6 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
    private static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter YMDHMS = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static final DateTimeFormatter YMD = DateTimeFormatter.ofPattern("yyyyMMdd");

    public void process(TableInfoDto config, List<Tuple> results, String partition) {
        int totalCount = config.getMonthCnt();
        Iterator<LocalDateTime> dateIterator = splitMonthIterator(partition, totalCount);
        List<String> columns = resolveColumns(config);
        String insertSql = buildInsertSql(config, columns);

        int batchSize = config.getBatchSize() > 0 ? config.getBatchSize() : 1000;
        Random rng = new Random();

        Session session = em.unwrap(Session.class);
        session.doWork(conn -> {
            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                int count = 0;
                int total = 0;
                for (int i = 0; i < totalCount; i++) {
                    LocalDateTime ts = dateIterator.next();
                    Tuple t = results.get(rng.nextInt(results.size()));
                    int idx = 1;
                    for (String col : columns) {
                        String rule = config.getData().get(col);
                        idx = bindValue(ps, idx, rule, t, col, ts);
                    }
                    ps.addBatch();
                    count++;

                    boolean last = (i == totalCount - 1);
                    if (count == batchSize || last) {
                        ps.executeBatch();
                        total += count;
                        count = 0;
                        System.out.println(total);
                    }
                }
            }
        });
    }

    private List<String> resolveColumns(TableInfoDto config) {
        List<String> columns = new ArrayList<>();
        for (Map.Entry<String, String> entry : config.getData().entrySet()) {
            String rule = entry.getValue();
            if (!"auto".equalsIgnoreCase(rule)) {
                columns.add(entry.getKey());
            }
        }
        return columns;
    }

    private String buildInsertSql(TableInfoDto config, List<String> columns) {
        String verb = config.isIgnore() ? "INSERT IGNORE" : "INSERT";
        StringBuilder sb = new StringBuilder();
        sb.append(verb).append(" INTO ").append(config.getTable()).append("\n");
        sb.append("(").append(String.join(", ", columns)).append(")").append("\n");
        sb.append("VALUES (");
        for (int i = 0; i < columns.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append("?");
        }
        sb.append(")");
        return sb.toString();
    }

    private int bindValue(PreparedStatement ps, int index, String rule, Tuple t, String col, LocalDateTime ts)
            throws SQLException {
        if (rule == null || "none".equalsIgnoreCase(rule)) {
            setParam(ps, index, t.get(col));
            return index + 1;
        }
        switch (rule.toLowerCase(Locale.ROOT)) {
            case "timestemp":
                ps.setString(index, ts.format(TS));
                return index + 1;
            case "timestemps":
                ps.setString(index, ts.format(TS6));
                return index + 1;
            case "date":
                ps.setString(index, ts.toLocalDate().format(DATE));
                return index + 1;
            case "ymdhms":
                ps.setString(index, ts.format(YMDHMS));
                return index + 1;
            case "ymd":
                ps.setString(index, ts.toLocalDate().format(YMD));
                return index + 1;
            case "auto":
                return index;
            default:
                throw new IllegalArgumentException("Unknown rule: " + rule + " for column " + col);
        }
    }

    private void setParam(PreparedStatement ps, int index, Object value) throws SQLException {
        if (value == null) {
            ps.setNull(index, Types.VARCHAR);
            return;
        }
        ps.setObject(index, value);
    }

    private Iterator<LocalDateTime> splitMonthIterator(String yearMonth, int totalCount) {
        int year = Integer.parseInt(yearMonth.substring(0, 4));
        int month = Integer.parseInt(yearMonth.substring(5, 7));

        LocalDate startDate = LocalDate.of(year, month, 1);
        int daysInMonth = startDate.lengthOfMonth();
        long totalSeconds = daysInMonth * 24L * 60L * 60L;
        long totalNanos = totalSeconds * 1_000_000_000L;
        long base = totalNanos / totalCount;
        long remainder = totalNanos % totalCount;

        LocalDateTime start = startDate.atStartOfDay();

        return new Iterator<>() {
            private long index = 0;

            @Override
            public boolean hasNext() {
                return index < totalCount;
            }

            @Override
            public LocalDateTime next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                long offset = (index * base) + Math.min(index, remainder);
                LocalDateTime timestamp = start.plusNanos(offset);
                index++;
                return timestamp;
            }
        };
    }
}
