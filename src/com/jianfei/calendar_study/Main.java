package com.jianfei.calendar_study;

import java.util.Calendar;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-07-26 20:00
 */
public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.MAY, 1);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2018, Calendar.JUNE, 2);
        System.out.println("第一个日历->" + calendar.getTimeInMillis());
        System.out.println("第二个日历->" + calendar1.getTimeInMillis());

        Calendar c1 = Calendar.getInstance();//新建一个calendar类
        Calendar c2 = Calendar.getInstance();//新建第二个calendar类
        Runtime run1 = Runtime.getRuntime();
        Runtime run2 = Runtime.getRuntime();
        System.out.println("c1.equals(c2) is " + c1.equals(c2));
        System.out.println("c1 == c2 is " + (c1 == c2));
        System.out.println("run1.equals(run2) is " + run1.equals(run2));
        System.out.println("run1 == run2 is " + (run1 == run2));
    }
}
