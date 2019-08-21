package com.jianfei.threadsafe;

import java.util.List;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-08-14 15:11
 */
public class MyThread implements Runnable {
    private List<String> list;
    private String name;

    public MyThread(List<String> list, String name) {
        this.list = list;
        this.name = name;
    }

    @Override
    public void run() {
        //System.out.println("abc");
        for (int i = 1; i <= 50; i ++) {
            list.add("a");
        }
        System.out.println("线程" + name + "执行完毕");
    }
}
