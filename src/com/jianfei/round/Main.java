package com.jianfei.round;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal("2.106786000");
        String testValue = decimal.setScale(1, RoundingMode.UP).toString();
        System.out.println("测试2.93 RoundingMode.UP:" + testValue);
    }
}
