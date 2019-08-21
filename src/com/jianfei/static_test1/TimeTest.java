package com.jianfei.static_test1;

import java.util.Date;

public class TimeTest {
    public static void main(String[] args) {
        long yesterday = Long.valueOf("1556639998000");
        //long currentTimeMillis = System.currentTimeMillis();
        long currentTimeMillis = Long.valueOf("1556640001000");
        Date date = new Date(yesterday);
        long hoursToSecond = date.getHours() * 3600;
        long hoursToMinutes = date.getMinutes() * 60;
        long seconds = date.getSeconds();
        long speedsSeconds = (hoursToSecond + hoursToMinutes + seconds) * 1000;
        long oneDayStart = yesterday - speedsSeconds;
        long oneMoreDay = oneDayStart + 86400000;
        System.out.println("一天的开始毫秒-->>" + oneDayStart);
        System.out.println("未来的一天的开始毫秒-->>" + oneMoreDay);
        if (currentTimeMillis > oneMoreDay) {
            System.out.println("超过凌晨");
        } else {
            System.out.println("还是当日");
        }
    }

}
