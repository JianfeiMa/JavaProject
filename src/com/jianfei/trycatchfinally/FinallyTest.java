package com.jianfei.trycatchfinally;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-10-05 08:31
 */
public class FinallyTest {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        int b = 20;
        try {
            System.out.println("try block");
            return b = b + 80;
        } catch (Exception e) {
            System.out.println("catch block");
        } finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b > 25, b = " + b);
            }
            b = 150;
        }
        return b;
    }
}
