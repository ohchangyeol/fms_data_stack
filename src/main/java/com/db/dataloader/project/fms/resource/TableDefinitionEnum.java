package com.db.dataloader.project.fms.resource;

import com.db.dataloader.rsc.CommonConstant;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TableDefinitionEnum {
    /**  테이블명                                       스키마명                          월 증가                  기준 건수                보관주기(개월)      */
    // TB_ACCIDENT_VEHICLES                            (.SCHEMA_UFMSNEW,  100,       6000,       60),
    // TB_ADMIN_MENUS                                  (CommonConstant.SCHEMA_UFMSNEW,  10000,     600000,     60),
    // TB_ADMIN_USERS                                  (CommonConstant.SCHEMA_UFMSNEW,  120,       7201,       60),
    // TB_ADMIN_USERS_HISTORIES                        (CommonConstant.SCHEMA_UFMSNEW,  330,       4290,       12),
    // TB_AGENCY_MANAGEMENTS                           (CommonConstant.SCHEMA_UFMSNEW,  20,        1400,       60),
    // TB_APP_ERR_HISTORIES                            (CommonConstant.SCHEMA_UFMSNEW,  600,       7800,       12),
    // TB_AUTHORITY_MANAGEMENTS                        (CommonConstant.SCHEMA_UFMSNEW,  10,        603,        60),
    // TB_AUTHORITY_MENUS                              (CommonConstant.SCHEMA_UFMSNEW,  1300,      78093,      60),
    // TB_BANNER_INFORMATION                           (CommonConstant.SCHEMA_UFMSNEW,  0,         20,         60),
    // TB_BASE_MANAGEMENTS                             (CommonConstant.SCHEMA_UFMSNEW,  100,       6000,       60),
    // TB_BASE_VEHICLE_INFO                            (CommonConstant.SCHEMA_UFMSNEW,  1000,      60000,      60),
    // TB_BAT_EXE_STAT                                 (CommonConstant.SCHEMA_UFMSNEW,  120000,    840000,     6),
    // TB_BAT_INFO_M                                   (CommonConstant.SCHEMA_UFMSNEW,  0,         38,         60),
    // TB_BUS_BOARDING_INFO                            (CommonConstant.SCHEMA_UFMSNEW,  300,       18000,      60),
    // TB_BUS_OPERATION_HISTORIES                      (CommonConstant.SCHEMA_UFMSNEW,  700,       9100,       12),
    // TB_BUS_OPERATION_INFO                           (CommonConstant.SCHEMA_UFMSNEW,  10,        600,        60),
    // TB_BUS_OPERATION_SET                            (CommonConstant.SCHEMA_UFMSNEW,  50,        3000,       60),
    // TB_BUS_PASSENGER_BOARDING_HISTORIES             (CommonConstant.SCHEMA_UFMSNEW,  2000,      26000,      12),
    // TB_BUSINESS                                     (CommonConstant.SCHEMA_UFMSNEW,  135,       8101,       60),
    // TB_BUSINESS_PLACE                               (CommonConstant.SCHEMA_UFMSNEW,  40,        2400,       60),
    // TB_CARBON_DIOXIDE_CALCULATION_BASICS            (CommonConstant.SCHEMA_UFMSNEW,  0,         5,          60),
    // TB_CATEGORY_MANAGEMENTS                         (CommonConstant.SCHEMA_UFMSNEW,  1,         120,        60),
    // TB_COMMON_GROUPS                                (CommonConstant.SCHEMA_UFMSNEW,  0,         50,         60),
    // TB_COMMON_GROUPS_CODE                           (CommonConstant.SCHEMA_UFMSNEW,  0,         1030,       60),
    // TB_CONSUMABLE_MANAGEMENTS                       (CommonConstant.SCHEMA_UFMSNEW,  20,        1200,       60),
    // TB_CONSUMABLE_REPLACEMENT_HISTORIES             (CommonConstant.SCHEMA_UFMSNEW,  150,       1950,       12),
    // TB_CONTACT_INFORMATION                          (CommonConstant.SCHEMA_UFMSNEW,  40,        2400,       60),
    // TB_COST_STATISTICS                              (CommonConstant.SCHEMA_UFMSNEW,  900,       54000,      60),
    // TB_DAILY_RENTAL_STATISTICS                      (CommonConstant.SCHEMA_UFMSNEW,  700,       42000,      60),
    // TB_DEVICE_CONTRACT_MATCH_INFO                   (CommonConstant.SCHEMA_UFMSNEW,  3300,      198000,     60),
    // TB_DEVICE_DISABILITY_HISTORY                    (CommonConstant.SCHEMA_UFMSNEW,  3300,      6600,       1),
    // TB_DEVICE_INSTALLATION_REQUEST_ATTACH           (CommonConstant.SCHEMA_UFMSNEW,  1500,      90000,      60),
    // TB_DEVICE_MANAGEMENTS                           (CommonConstant.SCHEMA_UFMSNEW,  1,         62,         60),
    // TB_DEVICE_STATE_CODE                            (CommonConstant.SCHEMA_UFMSNEW,  0,         16,         60),
    // TB_DIRECT_INQUIRY                               (CommonConstant.SCHEMA_UFMSNEW,  120,       7200,       60),
    // TB_DIRECT_INQUIRY_ATTACH_FILE                   (CommonConstant.SCHEMA_UFMSNEW,  10,        600,        60),
    // TB_DTC_CODE                                     (CommonConstant.SCHEMA_UFMSNEW,  0,         3595,       60),
    // TB_DTC_HISTORIES                                (CommonConstant.SCHEMA_UFMSNEW,  3300,      6600,       1),
    // TB_ECONOMIC_DRIVING_INDEX                       (CommonConstant.SCHEMA_UFMSNEW,  0,         5,          60),
    // TB_ETAS_SEND_HISTORIES                          (CommonConstant.SCHEMA_UFMSNEW,  2000,      26000,      12),
    // TB_FAQS                                         (CommonConstant.SCHEMA_UFMSNEW,  1,         80,         60),
    // TB_FINES                                        (CommonConstant.SCHEMA_UFMSNEW,  10,        600,        60),
    // TB_FMS_DEVICE_NUMBER                            (CommonConstant.SCHEMA_UFMSNEW,  3300,      198000,     60),
    // TB_GEO_FENCING_APPLIED_VEHICLE                  (CommonConstant.SCHEMA_UFMSNEW,  10,        600,        60),
    // TB_GEO_FENCING_MANAGEMENTS                      (CommonConstant.SCHEMA_UFMSNEW,  10,        600,        60),
    // TB_HIPASS_PAYMENT_MANAGEMENTS                   (CommonConstant.SCHEMA_UFMSNEW,  100,       6000,       60),
    // TB_IMAGE_ATTACH_INFO                            (CommonConstant.SCHEMA_UFMSNEW,  100,       6000,       60),
    // TB_INACTIVE_USERS                               (CommonConstant.SCHEMA_UFMSNEW,  50,        3000,       60),
    // TB_LOGIN_HISTORIES                              (CommonConstant.SCHEMA_UFMSNEW,  7500,      97500,      12),
    // TB_MAINTENANCE_VEHICLES                         (CommonConstant.SCHEMA_UFMSNEW,  100,       6000,       60),
    // TB_MENUS                                        (CommonConstant.SCHEMA_UFMSNEW,  0,         95,         60),
    // TB_MOBILE_CONTRACT_DEVICE_INSTALLATION_REQUEST  (CommonConstant.SCHEMA_UFMSNEW,  3300,      198000,     60),
    // TB_NOTICES                                      (CommonConstant.SCHEMA_UFMSNEW,  30,        1805,       60),
    // TB_NOTIFICATION                                 (CommonConstant.SCHEMA_UFMSNEW,  10,        600,        60),
    // TB_OIL_COST_MANAGEMENT                          (CommonConstant.SCHEMA_UFMSNEW,  1500,      19500,      12),
    // TB_OPENAPI_APPLICATION                          (CommonConstant.SCHEMA_UFMSNEW,  2,         120,        60),
    // TB_OPENAPI_APPLICATION_SERVICE_ENVIRONMENT      (CommonConstant.SCHEMA_UFMSNEW,  1,         60,         60),
    // TB_OPENAPI_DAILY_USE_STATISTICS                 (CommonConstant.SCHEMA_UFMSNEW,  60,        3600,       60),
    // TB_OPENAPI_HISTORIES                            (CommonConstant.SCHEMA_UFMSNEW,  36000,     468000,     12),
    // TB_OPENAPI_MANAGEMENTS                          (CommonConstant.SCHEMA_UFMSNEW,  2,         120,        60),
    // TB_OPENAPI_USER_GUIDE                           (CommonConstant.SCHEMA_UFMSNEW,  1,         62,         60),
    // TB_PARTNER_WORK_CLASSIFICATION                  (CommonConstant.SCHEMA_UFMSNEW,  10,        601,        60),
    // TB_PASSENGER_MANAGEMENT                         (CommonConstant.SCHEMA_UFMSNEW,  1000,      60000,      60),
    // TB_PENALTIES                                    (CommonConstant.SCHEMA_UFMSNEW,  100,       6000,       60),
    // TB_PERSONAL_INFO_AUTHORITY_HISTORIES            (CommonConstant.SCHEMA_UFMSWD,   120,       7201,       60),
    // TB_PERSONAL_INFO_DESTRUCTION_DETAIL             (CommonConstant.SCHEMA_UFMSWD,   10,        600,        60),
    // TB_PERSONAL_INFO_DOWN_MONITOR                   (CommonConstant.SCHEMA_UFMSWD,   170,       10200,      60),
    // TB_PERSONAL_INFO_OFFER_CONFIRM                  (CommonConstant.SCHEMA_UFMSWD,   3300,      198000,     60),
    // TB_PERSONAL_INFO_PROVIDED_3RDPARTY              (CommonConstant.SCHEMA_UFMSWD,   10,        600,        60),
    // TB_PERSONAL_INFO_VIEW_CONFIRM                   (CommonConstant.SCHEMA_UFMSWD,   10,        600,        60),
    // TB_PREMIUMS                                     (CommonConstant.SCHEMA_UFMSNEW,  3300,      198000,     60),
    // TB_PROGRAM_FILE_NAMES                           (CommonConstant.SCHEMA_UFMSNEW,  2000,      120000,     60),
    // TB_REFERENCE_ROOM                               (CommonConstant.SCHEMA_UFMSNEW,  10,        600,        60),
    // TB_REFERENCE_ROOM_ATTACH                        (CommonConstant.SCHEMA_UFMSNEW,  100,       6000,       60),
    // TB_RESERVATION                                  (CommonConstant.SCHEMA_UFMSNEW,  6600,      85800,      12),
    // TB_SAFE_DRIVING_INDEX                           (CommonConstant.SCHEMA_UFMSNEW,  0,         8,          60),
    // TB_SAFETY_DRIVING_DATA                          (CommonConstant.SCHEMA_UFMSNEW,  18500,     2405000,    12),
    // TB_SMS_RECIPIENTS                               (CommonConstant.SCHEMA_UFMSNEW,  100,       6000,       60),
    // TB_SMS_RECIPIENTS_MANAGEMENTS                   (CommonConstant.SCHEMA_UFMSNEW,  2000,      120000,     60),
    // TB_SMS_SENDING_GROUP                            (CommonConstant.SCHEMA_UFMSNEW,  100,       6000,       60),
    // TB_SMS_SENDING_HISTORIES                        (CommonConstant.SCHEMA_UFMSNEW,  4700,      61100,      12),
    // TB_SMS_SENDING_MEMBER                           (CommonConstant.SCHEMA_UFMSNEW,  600,       36000,      60),
    // TB_SMS_TEMPLATE                                 (CommonConstant.SCHEMA_UFMSNEW,  0,         20,         60),
    // TB_SMS_TOKEN                                    (CommonConstant.SCHEMA_UFMSNEW,  0,         1,          60),
    // TB_SUBSCRIPTION_SERVICE                         (CommonConstant.SCHEMA_UFMSNEW,  40,        2400,       60),
    // TB_TERM_CONDITION_AGREEMENTS                    (CommonConstant.SCHEMA_UFMSNEW,  1200,      72000,      60),
    // TB_TERM_CONDITIONS                              (CommonConstant.SCHEMA_UFMSNEW,  1,         12,         60),
    // TB_TRUCK_ACCEPTANCE_CERTIFICATE_ATTACH          (CommonConstant.SCHEMA_UFMSNEW,  200,       12000,      60),
    // TB_TRUCK_DELIVERY_HISTORIES                     (CommonConstant.SCHEMA_UFMSNEW,  1600,      20800,      12),
    // TB_TRUCK_OPERATION_INFO                         (CommonConstant.SCHEMA_UFMSNEW,  100,       6000,       60),
    // TB_TRUCK_OPERATION_SET                          (CommonConstant.SCHEMA_UFMSNEW,  100,       6000,       60),
    // TB_TRUCK_OPTION_SET                             (CommonConstant.SCHEMA_UFMSNEW,  200,       12000,      60),
    // TB_UCUBE_CONTRACT                               (CommonConstant.SCHEMA_UFMSNEW,  3300,      198000,     60),
    // TB_UCUBE_CONTRACT_CHANGE_HISTORIES              (CommonConstant.SCHEMA_UFMSNEW,  3300,      42900,      12),
    // TB_UCUBE_CONTRACT_DEVICE                        (CommonConstant.SCHEMA_UFMSNEW,  3300,      198000,     60),
    // TB_UCUBE_CONTRACT_PRODUCT                       (CommonConstant.SCHEMA_UFMSNEW,  3300,      198000,     60),
    // TB_UCUBE_DEVICE_CHANGE_HISTORIES                (CommonConstant.SCHEMA_UFMSNEW,  3300,      42900,      12),
    // TB_UCUBE_PAYMENT_PLAN                           (CommonConstant.SCHEMA_UFMSNEW,  0,         13,         60),
    // TB_UCUBE_PRODUCT_CHANGE_HISTORIES               (CommonConstant.SCHEMA_UFMSNEW,  3300,      42900,      12),
    // TB_UNMASKING_REASON_HISTORIES                   (CommonConstant.SCHEMA_UFMSWD,   140,       8400,       60),
    // TB_USER_WIDGET_SET                              (CommonConstant.SCHEMA_UFMSNEW,  2700,      162296,     60),
    // TB_USERS                                        (CommonConstant.SCHEMA_UFMSNEW,  2000,      120000,     60),
    // TB_USERS_HISTORIES                              (CommonConstant.SCHEMA_UFMSNEW,  2000,      26000,      12),
    // TB_VEHICLE_BUS                                  (CommonConstant.SCHEMA_UFMSNEW,  680,       40800,      60),
    // TB_VEHICLE_MODELS_BY_CONSUMABLES                (CommonConstant.SCHEMA_UFMSNEW,  100,       6000,       60),
    // TB_VEHICLE_OPERATION_DAILY                      (CommonConstant.SCHEMA_UFMSNEW,  27000,     351000,     12),
    TB_VEHICLE_OPERATION_RECORDS                    (CommonConstant.SCHEMA_UFMSNEW,  10000,    250000,    24)
    // TB_VEHICLE_RENT_CAR                             (CommonConstant.SCHEMA_UFMSNEW,  1000,      60000,      60),
    // TB_VEHICLE_SPECIAL_EQUIPMENT                    (CommonConstant.SCHEMA_UFMSNEW,  20,        1200,       60),
    // TB_VEHICLE_STATUS_INFO                          (CommonConstant.SCHEMA_UFMSNEW,  3300,      198000,     60),
    // TB_VEHICLE_TRUCK                                (CommonConstant.SCHEMA_UFMSNEW,  1600,      96000,      60),
    // TB_VEHICLES                                     (CommonConstant.SCHEMA_UFMSNEW,  3300,      198000,     60),
    // TB_VEHICLES_MODEL_MANAGEMENT                    (CommonConstant.SCHEMA_UFMSNEW,  125,       7600,       60),
    // TB_VOC_MAINTENANCE_ATTACH_IMAGE                 (CommonConstant.SCHEMA_UFMSNEW,  10,        600,        60),
    // TB_VOC_MAINTENANCE_MANAGEMENTS                  (CommonConstant.SCHEMA_UFMSNEW,  10,        600,        60),
    // TB_VOC_MANAGEMENTS                              (CommonConstant.SCHEMA_UFMSNEW,  10,        600,        60),
    // TB_WIDGET_MANAGEMENTS                           (CommonConstant.SCHEMA_UFMSNEW,  0,         14,         60),
    // TB_WITHDRAWAL_USERS                             (CommonConstant.SCHEMA_UFMSWD,   10,        600,        60),
    // TB_COST_STATISTICS_HISTORIES                    (CommonConstant.SCHEMA_UFMSLOG,  300,       2100,       6),
    // TB_TRUCK_ALARM_MANAGEMENT                       (CommonConstant.SCHEMA_UFMSNEW,  30,        1800,       60),
    // TB_TRUCK_ALARM_RECIPIENTS                       (CommonConstant.SCHEMA_UFMSNEW,  60,        3600,       60),
    // TB_TRUCK_ALARM_HISTORIES                        (CommonConstant.SCHEMA_UFMSNEW,  300,       3900,       12),
    // TB_GEO_FENCING_RECIPIENTS                       (CommonConstant.SCHEMA_UFMSNEW,  30,        1800,       60),
    // TB_GEO_FENCING_ALARM_HISTORIES                  (CommonConstant.SCHEMA_UFMSNEW,  60,        780,        12),
    // TB_VEHICLE_OPERATION_EVENT_DATA                 (CommonConstant.SCHEMA_UFMSNEW,  300,       7500,       24),
    // TB_VEHICLE_OPERATION_NATIONALTAX_LOG            (CommonConstant.SCHEMA_UFMSNEW,  160000,    9600000,    60),
    // TB_VEHICLE_MAINTENANCE_HISTORIES                (CommonConstant.SCHEMA_UFMSLOG,  30,        390,        12),
    // TB_PERSONAL_INFOVIEW_HISTORIES                  (CommonConstant.SCHEMA_UFMSWD,   300,       7500,       24),
    // TB_BUSINESS_MANAGEMENT                          (CommonConstant.SCHEMA_UFMSNEW,  135,       8100,       60),
    // TB_OPERATION_STATISTICS                         (CommonConstant.SCHEMA_UFMSNEW,  60000,     3600000,    60),
    // TB_VEHICLE_SPEEDING_ALARM_RECIPIENTS            (CommonConstant.SCHEMA_UFMSNEW,  60,        3600,       60),
    // TB_VEHICLE_SPEEDING_ALARM_HISTORIES             (CommonConstant.SCHEMA_UFMSNEW,  300,       3900,       12),
    // TB_COST_ATTACH_FILE                             (CommonConstant.SCHEMA_UFMSNEW,  10,        600,        60),
    // TB_VEHICLE_ACC_KECO_DATA                        (CommonConstant.SCHEMA_UFMSLOG,  300,       7500,       24),
    // TB_VEHICLE_ACC_MEMS_DATA                        (CommonConstant.SCHEMA_UFMSLOG,  300,       7500,       24)
    ;

    private final String schema;
    private final int increaseMonth;
    private final int baseCount;
    private final int storageDuration;

    TableDefinitionEnum(String schema, int increaseMonth, int baseCount, int storageDuration) {
        this.schema = schema;
        this.increaseMonth = increaseMonth;
        this.baseCount = baseCount;
        this.storageDuration = storageDuration;
    }

    public static TableDefinitionEnum findByNameAndSchema(String schema, String name) {
        return Arrays.stream(TableDefinitionEnum.values())
                .filter(td -> td.name().equalsIgnoreCase(name) && td.getSchema().equalsIgnoreCase(schema))
                .findFirst()
                .orElse(null);
    }

}
