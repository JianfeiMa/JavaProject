package com.jianfei.thread;

/**
 * author: JianfeiMa
 * email: majianfei93@163.com
 * created date: 2019-09-03 19:11
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" 执行完毕 ");
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        thread.join();
        System.out.println(" 我想在 thread 执行完之后执行，我做到了 ");
    }
}
