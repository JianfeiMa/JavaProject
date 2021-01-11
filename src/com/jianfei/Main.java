package com.jianfei;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-12-05 15:30
 */
public class Main {
    public static void main(String[] args) {
        String test = "123,369,296";
        String[] test1 = test.split(",");
        for (int i = 0; i < test1.length; i ++) {
            System.out.println("di" + i + "->" + test1[i]);
            if (test1[i].equals("296")) {
                test1[i] = null;
            }
        }
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < test1.length; j ++) {
            System.out.println("之后296之后打印：->" + test1[j]);
            if (test1[j] != null) {
                s.append(test1[j]);
                s.append(",");
            }
        }
        String z = s.substring(0, s.lastIndexOf(","));
        System.out.println(z);
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date date = dateFormat.parse("2020-07-30 09:10");
            System.out.println(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
