package com.jianfei.decimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("41.00").setScale(2, RoundingMode.HALF_UP);
        BigDecimal bigDecimal1 = new BigDecimal("1.00").setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = bigDecimal.divide(bigDecimal1, 0, RoundingMode.DOWN);
        System.out.println(result.toPlainString());
        float a = 0.3f;
        float b = 0.2f;
        float c = a - b;
        System.out.println("c->" + c);
        double d = 0.3d;
        double e = 0.2d;
        double f = d - e;
        System.out.println("f->" + f);
        BigDecimal z = new BigDecimal("0");
        BigDecimal y = new BigDecimal("0.2");
        BigDecimal x = z.subtract(y);
        System.out.println("BigDecimal->" + x.toPlainString());
        byte w = 1;
        short v = 2;
        int u = 3;
        long t = 413424234235235124L;
        float s = 5.4f;
        double r = 6.3d;
        boolean q = true;
        char p = 'a';
        Byte byteRefer = w;
        Short shortRefer = v;
        Integer integerRefer = u;
        Long longRefer = t;
        Float floatRefer = s;
        Double doubleRefer = r;
        Boolean booleanRefer = q;
        String string = String.valueOf(p);
        System.out.println(byteRefer);
        System.out.println(shortRefer);
        System.out.println(integerRefer);
        System.out.println(longRefer);
        System.out.println(floatRefer);
        System.out.println(doubleRefer);
        System.out.println(booleanRefer);
        System.out.println(string);
        System.out.println("-----------------------------");
        /*long[] buffer = new long[10000000];
        for (int i = 0; i < buffer.length; i ++) {
            buffer[i] = i;
            System.out.println(i);
        }*/
        /*for (long ss : buffer) {
            System.out.println(ss);
        }*/
        String test = "中";
        byte[] bu = test.getBytes();
        for (int i = 0; i < bu.length; i ++) {
            System.out.println("->" + bu[i]);
            System.out.println(Integer.toBinaryString(bu[i]));
        }
        System.out.println("---------------------------");
        System.out.println(Integer.toBinaryString(-28));
        System.out.println(Integer.toBinaryString(-72));
        System.out.println(Integer.toBinaryString(-83));
        float a1 = 0.1f;
        float sum = 0f;
        for (int i = 0; i < 10000; i ++) {
            sum += a1;
        }
        System.out.println("浮点数相加->" + sum);
        BigDecimal b1 = new BigDecimal("0.1");
        BigDecimal sum1 = new BigDecimal("0.0");
        for (int i = 0;i < 10000; i ++) {
            sum1 = sum1.add(b1);
        }
        System.out.println("BigDecimal相加->" + sum1.toPlainString());
    }
}
