package com.db.initalizr.utils;

import ch.qos.logback.core.util.StringUtil;
import com.db.initalizr.dto.TableColumnDetail;
import com.db.initalizr.resource.CommonConstant;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.util.ObjectUtils;


public class CommonUtils {

    /**
     * sql value 값 세팅
     * @param detail
     * @param startIdx
     * @return
     */
    public static Object setFieldValue(TableColumnDetail detail ,Integer startIdx, Timestamp ts) {
        Object value = null;
        if ("String".equals(detail.getColumnType())){
            long maxLength = detail.getCharacterMaximumLength();
            if( 1 == maxLength){
                value = "T";
            } else if (maxLength != 0 && String.valueOf(startIdx).length() > maxLength){
                value = String.valueOf(startIdx).substring(0, (int) maxLength);
            } else{
                value = setStringOriginalColumnType(detail, startIdx);
            }
            // 고정 value 우선 처리
            value = setFixValue(detail, value);

        }else if ("Timestamp".equals(detail.getColumnType())){
            value = ts;
        }else if ("long".equals(detail.getColumnType())){
            if(String.valueOf(startIdx).length() > detail.getCharacterMaximumLength()){
                value = Long.valueOf(0);
            }else{
                value = Long.valueOf(startIdx);
            }
        }else if ("double".equals(detail.getColumnType())){
            value = 0.0;
        }else if ("Date".equals(detail.getColumnType())){
            value = new Date(ts.getTime());
        }else if ("mediumtext".equals(detail.getColumnType())){
            value = CommonConstant.DATA_CONTENT;
        }else if ("time".equals(detail.getColumnType())){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            value = LocalTime.now().format(formatter);
        }


        return value;
    }

    public static Object setFixValue(TableColumnDetail detail, Object value) {
        String columnName = detail.getColumnName();
        if (List.of("user_name", "name", "updater_id").contains(columnName)) {
           value = CommonConstant.DATA_DUMMY;
       } else if ("mblEncnStusChgCd".equals(columnName)){
            value = getRandomElement(CommonConstant.DATA_MBL_ENCN_STUS_CHG_CD, value);
        } else if ("prodKdCd".equals(columnName)){
            value = getRandomElement(CommonConstant.DATA_PROD_KD_CD, value);
        }
        return value;
    }

    private static String setStringOriginalColumnType(TableColumnDetail detail, Integer startIdx) {
        String value;
        switch (detail.getColumnTypeOrigin()){
            case "point" :
                value = CommonConstant.DATA_POINT;
                break;
            default :
                value = String.valueOf(startIdx);
                break;
        }
        return value;
    }

    private static Object getRandomElement(List<String> list ,Object value) {
        if (list == null || list.isEmpty()) return value;
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    /**
     * 첫글자 마지막 글자 제거
     * @param str
     * @return
     */
    public static String stripFirstAndLast(String str) {
        if(StringUtil.isNullOrEmpty(str)){
            return null;
        }
        if(str.length() <= 2){ // [] 일 경우
            return null;
        }

        return str.substring(1, str.length() - 1);
    }


    /**
     * JPA : Entity 값 세팅
     * @param target
     * @param columnName
     * @param value
     */
    /*
    public static void setFieldValue(Object target, String columnName, Object value) {
        try {
            // field 이름과 columnName을 소문자로 비교
            Field field = target.getClass().getDeclaredField(columnName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("필드 '" + columnName + "' 이(가) class 에 없습니다: " + target.getClass().getName(), e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("필드 접근 불가: " + columnName, e);
        }
    }
    */

    /**
     * JPA : Entity 찾기
     * @param schema
     * @param tableName
     * @return
     */
    public static Class<?> findEntityBySchemaAndTable(String schema, String tableName) {
        Reflections reflections = new Reflections("com.db.initalizr.entity");

        Set<Class<?>> entities = reflections.getTypesAnnotatedWith(Entity.class);

        for (Class<?> entity : entities) {
            Table table = entity.getAnnotation(Table.class);
            if (table != null &&
                    table.schema().equalsIgnoreCase(schema) &&
                    table.name().equalsIgnoreCase(tableName)) {
                return entity;
            }
        }
        throw new IllegalArgumentException("Entity not found for schema: " + schema + ", table: " + tableName);
    }

}
