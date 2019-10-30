package com.jianfei.timerandtimertask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-09-17 19:02
 */
public class Main {
    private static int i;
    public static void main(String[] args) {
//        Timer timer = new Timer("I'm Timer");
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("定时任务开始执行了");
//            }
//        }, 3000);
        //Date date = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.SEPTEMBER, 17, 21, 0, 0);
        System.out.println("2019-09-17 21:00的时间戳->" + calendar.getTimeInMillis());
        System.out.println("将有一个定时任务在每晚的21点准时执行炸弹爆炸,一个月之后将会炸毁整个地球村");
        Timer timer1 = new Timer("I'm Timer1");
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                i ++;
                System.out.println("延迟4秒后执行，一分钟执行一次这个任务" + i);
                try {
                    URL url = new URL("http://127.0.0.1:8081/sell1/blog/getMatch?expressNumber=" + "88888888" + i + "&memberNumber=B801");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String line;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                    System.out.println("->" + stringBuilder.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, new Date(System.currentTimeMillis() + 500), 1000);
        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("ScheduledExecutorService实现的定时任务,6秒开始执行");
            }
        };
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(runnable, 6000, TimeUnit.NANOSECONDS);*/

    }
}
