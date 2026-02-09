## 규격
- table : 테이블명 
- monthCnt : 월증가건수
- select : select 쿼리
- ignore : ignore 여부
- partitions : 생성할 partitions 
- data : 컬럼 설정
### data 컬럼 옵션
  - none : 변경 없이 저장
  - auto : auto_increment (insert 추가안함)
  - date : yyyy-MM-dd
  - ts : yyyy-MM-dd HH:mm:ss
  - ts3 : yyyy-MM-dd HH:mm:ss.SSS
  - ymd : 날짜 평문 (yyyymmdd)
  - ymdhms : 날짜 평문 (yyyymmddhhmmss)
  - ymdhms3 : 날짜 평문 (yyyyMMddHHmmssSSS)
  

## 예시
- POST `/data/batchTableList`
```json
[
  {
    "table": "TB_IOT_OUT_MSG_H_SUB",
    "monthCnt": 3600000,
    "select" : "SELECT * FROM TB_IOT_OUT_MSG_H_SUB PARTITION (P_202511)",
    "ignore": true,
    "partitions":[
      "2025-11"
    ],
    "data" : {
      "FIRST_DTTM":"ts",
      "OUT_MSG_HIST_SEQ":"none",
      "OUT_SVR_CD":"none",
      "REQ_DTTM":"ymdhms",
      "REQ_MSG":"none",
      "STATUS":"none",
      "RES_DTTM":"ymdhms",
      "RES_MSG":"none",
      "REG_USR_ID":"none",
      "REG_DTTM":"ymdhms"
    }
  }
]
```
- POST `/data/batchOneTable`
```json
{
    "table": "TB_IOT_OUT_MSG_H_SUB",
    "monthCnt": 3600000,
    "select" : "SELECT * FROM TB_IOT_OUT_MSG_H_SUB PARTITION (P_202511)",
    "ignore": true,
    "partitions":[
        "2025-11"
    ],
    "data" : {
        "FIRST_DTTM":"ts",
        "OUT_MSG_HIST_SEQ":"none",
        "OUT_SVR_CD":"none",
        "REQ_DTTM":"ymdhms",
        "REQ_MSG":"none",
        "STATUS":"none",
        "RES_DTTM":"ymdhms",
        "RES_MSG":"none",
        "REG_USR_ID":"none",
        "REG_DTTM":"ymdhms"
    }
}
```