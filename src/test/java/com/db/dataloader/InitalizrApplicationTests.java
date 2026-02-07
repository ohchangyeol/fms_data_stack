package com.db.dataloader;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;

import java.time.format.DateTimeFormatter;

@SpringBootTest
class InitalizrApplicationTests {
	@Autowired
	private EntityManager em;

	@Autowired
	private PlatformTransactionManager txManager;

	private static final DateTimeFormatter FORMATTER =
			DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	private static final DateTimeFormatter FORMATTER2 =
			DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"); // timestamp(6) 포맷



	@Test
	void contextLoads() {
		// String sql = "select " +
		// 		"DATE_FORMAT(API_LOG_DATE , '%Y-%m-%d %H:%i:%S') API_LOG_DATE , ML_SERVER_NM, ML_MODEL_NM, ML_TYPE_CD, IOT_MODEL_NM, DEV_UUID, CTN, DATE_FORMAT(REQ_TIME , '%Y-%m-%d %H:%i:%S') REQ_TIME, DATE_FORMAT(RES_TIME , '%Y-%m-%d %H:%i:%S') RES_TIME, REQ_DATA, RES_DATA, SUCC_YN, RESULT_CD" +
		// 		" from TB_AIGW_API_LOG PARTITION(P_202508)";
		// List<Tuple> results = em.createNativeQuery(sql, Tuple.class).getResultList();
		// System.out.println(results);
	}

	// @Test
	// void selectTest(){
	// 	TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition());
	//
	// 	String sql = "select " +
	// 			"DATE_FORMAT(API_LOG_DATE , '%Y-%m-%d %H:%i:%S') API_LOG_DATE , ML_SERVER_NM, ML_MODEL_NM, ML_TYPE_CD, IOT_MODEL_NM, DEV_UUID, CTN, DATE_FORMAT(REQ_TIME , '%Y-%m-%d %H:%i:%S') REQ_TIME, DATE_FORMAT(RES_TIME , '%Y-%m-%d %H:%i:%S') RES_TIME, REQ_DATA, RES_DATA, SUCC_YN, RESULT_CD" +
	// 			" from TB_AIGW_API_LOG PARTITION(P_202602)";
	// 	List<Tuple> results = em.createNativeQuery(sql, Tuple.class).getResultList();
	//
	// 	//  ***********************************************************************
	// 	// System.out.println(results);
	//
	// 	List<String> result = splitMonth("2026-03", 40_000);
	//
	// 	System.out.println("");
	//
	// 	int batchSize = 2000;
	// 	StringBuilder insertSql = new StringBuilder();
	// 	int count = 0;
	// 	String insertPrefix = """
	// 				INSERT INTO IIOT_SF.TB_AIGW_API_LOG
	// 				(API_LOG_DATE, ML_SERVER_NM, ML_MODEL_NM, ML_TYPE_CD, IOT_MODEL_NM, DEV_UUID, CTN, REQ_TIME, RES_TIME, REQ_DATA, RES_DATA, SUCC_YN, RESULT_CD)
	// 				values
	// 				""";
	//
	// 	for (int i = 0; i < result.size(); i++) {
	// 		if (count == 0) {
	// 			insertSql.setLength(0);
	// 			insertSql.append(insertPrefix);
	// 		}
	// 		String date = result.get(i);
	// 		Tuple t = results.get(new Random().nextInt(results.size()));
	// 		insertSql.append("(")
	// 				.append(toSql(date)).append(",")
	// 				.append(toSql(t.get("ML_SERVER_NM"))).append(",")
	// 				.append(toSql(t.get("ML_MODEL_NM"))).append(",")
	// 				.append(toSql(t.get("ML_TYPE_CD"))).append(",")
	// 				.append(toSql(t.get("IOT_MODEL_NM"))).append(",")
	// 				.append(toSql(t.get("DEV_UUID"))).append(",")
	// 				.append(toSql(t.get("CTN"))).append(",")
	// 				.append(toSql(date)).append(",")
	// 				.append(toSql(date)).append(",")
	// 				.append(toSql(t.get("REQ_DATA"))).append(",")
	// 				.append(toSql(t.get("RES_DATA"))).append(",")
	// 				.append(toSql(t.get("SUCC_YN"))).append(",")
	// 				.append(toSql(t.get("RESULT_CD")))
	// 				.append(")");
	// 		count++;
	//
	// 		boolean last = (i == result.size() - 1);
	//
	// 		if (count == batchSize || last) {
	// 			em.createNativeQuery(insertSql.toString()).executeUpdate();
	// 			em.flush();
	// 			em.clear();
	// 			count = 0;
	// 		} else {
	// 			insertSql.append(",");
	// 		}
	//
	// 	}
	//
	// }
	// private String toSql(Object v) {
	// 	if (v == null) return "null";
	// 	return "'" + v.toString().replace("'", "''") + "'";
	// }
	//
	// private List<String> splitMonth(String yearMonth, int totalCount) {
	// 	int year = Integer.parseInt(yearMonth.substring(0, 4));
	// 	int month = Integer.parseInt(yearMonth.substring(5, 7));
	//
	// 	LocalDate startDate = LocalDate.of(year, month, 1);
	// 	int daysInMonth = startDate.lengthOfMonth();
	// 	long totalSeconds = daysInMonth * 24L * 60L * 60L;
	//
	// 	long base = totalCount / totalSeconds;
	// 	long remainder = totalCount % totalSeconds;
	//
	// 	List<String> result = new ArrayList<>(totalCount);
	// 	LocalDateTime start = startDate.atStartOfDay();
	//
	// 	for (int i = 0; i < totalSeconds; i++) {
	// 		LocalDateTime secondStart = start.plusSeconds(i);
	//
	// 		long countThisSecond = base + (i < remainder ? 1 : 0);
	//
	// 		for (long j = 0; j < countThisSecond; j++) {
	// 			// 마이크로초 단위로 나누기
	// 			int microOffset = (int)((j * 1_000_000L) / countThisSecond);
	// 			LocalDateTime timestamp = secondStart.plusNanos(microOffset * 1000L);
	//
	// 			result.add(timestamp.format(FORMATTER2));
	// 		}
	// 	}
	//
	// 	return result;
	// }

}
