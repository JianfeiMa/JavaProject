package com.jianfei.thread;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-09-03 19:12
 */
public class LocalThread extends Thread {
    private static ThreadLocal local = new ThreadLocal();

    @Override
    public void run() {
        local.set(" 线程的值 ");
        System.out.println("thread 线程："+ local.get());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(local.get());
        local.set("main 的值 ");
        LocalThread t = new LocalThread();
        t.start();
        Thread.sleep(1000);
        System.out.println("main 线程："+ local.get());
    }

}
