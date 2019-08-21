package com.jianfei.stringtest;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-08-19 14:41
 */
public class KeyValueObject {
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "KeyValueObject{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
