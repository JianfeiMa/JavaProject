package com.jianfei.decimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("41.00").setScale(2, RoundingMode.HALF_UP);
        BigDecimal bigDecimal1 = new BigDecimal("1.00").setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = bigDecimal.divide(bigDecimal1, 0, RoundingMode.DOWN);
        System.out.println(result.toPlainString());
    }
}
