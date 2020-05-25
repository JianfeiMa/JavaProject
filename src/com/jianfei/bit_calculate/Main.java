package com.jianfei.bit_calculate;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2020-01-15 15:43
 */
public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        if (a > 4 || b-- > 8) {
            System.out.println(b);
        }

        if(a > 4 | b++ > 10) {
            System.out.println(b);
            //打印结果是11
        }
        long z = 1;
        long y = 2;
        long result = z | y;
        System.out.println(result);
        System.out.println("-------");

        boolean j = false;
        boolean f = true;
        System.out.println(j ^ f);
    }
}
