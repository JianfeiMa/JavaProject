package com.jianfei.stringtest;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-08-19 14:46
 */
public class KeyValueObjectMobile {
    private String mobile_phone;
    private boolean hidden;

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return "KeyValueObjectMobile{" +
                "mobile_phone='" + mobile_phone + '\'' +
                ", hidden=" + hidden +
                '}';
    }
}
