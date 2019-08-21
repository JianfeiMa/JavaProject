package com.jianfei.enum_study;

/**
 * Revised By JianfeiMa on 2019-06-17 15:48
 * Description:物流状态枚举
 */
public enum LogisticsStatusEnum implements CodeEnum {
    DISTRIBUTION_GOODS(1, "配貨中"),
    PREPARE_OUT_GOODS(2, "準備出貨"),
    OUTING_GOODS(3, "出貨中"),
    ARRIVED_SELF_HELP_SPOT(4, "到達自取點"),
    CUSTOMER_TAKE_OFF(5, "客人已取走")
    ;

    private Integer code;
    private String message;

    LogisticsStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
