package com.jianfei.think;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-10-19 09:38
 */
public class Util {

    public static void thisIsMethod() {
        Calendar calendar = Calendar.getInstance();
        long currentTime = calendar.getTimeInMillis();
        System.out.println(currentTime);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String sCurrentTime = dateFormat.format(calendar.getTime());
        System.out.println(sCurrentTime);
    }
}
