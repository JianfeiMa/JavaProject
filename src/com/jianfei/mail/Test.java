package com.jianfei.mail;

import java.math.BigDecimal;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2020-07-27 10:29
 */
public class Test {
    public static void main(String[] args) {
        BigDecimal money = new BigDecimal("167.96");
        money = money.subtract(new BigDecimal("10.00"));
        BigDecimal balance = new BigDecimal("158.00");
        int flag = balance.compareTo(money);
        System.out.println(flag);
        if (flag > 0 || flag == 0) {
            System.out.println("够");
        } else {
            System.out.println("不够");
        }
    }
}
