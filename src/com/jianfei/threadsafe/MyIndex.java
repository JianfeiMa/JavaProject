package com.jianfei.threadsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-08-14 15:05
 */
public class MyIndex {
    public static void main(String[] args) throws InterruptedException {
        /** java多线程 线程安全和不安全 */
        //Thread.sleep(100000);
        List<Thread> threadList = new ArrayList<>();
        List<String> myList = new Vector<>();
        for (int i = 1; i <= 5; i ++) {
            Thread thread = new Thread(new MyThread(myList, String.valueOf(i)));
            thread.setName(String.valueOf(i));
            thread.start();
            threadList.add(thread);
        }
        for (Thread t : threadList) {
            t.join();
        }
        /** 主线程即main线程的代码 */
        System.out.println(myList.size());
    }
}
