package com.jianfei.thread_mx_bean;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        try {
            myThread.join(5000);
            myThread.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }
    }

    static protected class MyThread extends Thread {

        public MyThread() {
            System.out.println("线程构造函数执行");
            System.out.println("[" + getId() + "]" + getName());
        }

        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程执行了");
            TestClass testClass = new TestClass();
        }
    }

    static class TestClass {
        public TestClass() {
            System.out.println("测试类构造函数执行");
        }
    }
}
