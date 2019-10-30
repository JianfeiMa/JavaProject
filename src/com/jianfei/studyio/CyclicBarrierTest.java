package com.jianfei.studyio;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Thread thread1 = new MyThread1(cyclicBarrier);
        executorService.execute(thread1);
        Thread thread2 = new MyThread2(cyclicBarrier);
        executorService.execute(thread2);
        Thread thread3 = new MyThread3(cyclicBarrier);
        executorService.execute(thread3);
//        for (int i = 0; i < 3; i++) {
//            //循环创建3个线程
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(new Random().nextInt(10000));
//                        System.out.println("线程"+Thread.currentThread().getName()+"即将到达1，当前已有"+(cyclicBarrier.getNumberWaiting()+1)+"已经到达"+(cyclicBarrier.getNumberWaiting()==2?"都到齐了，继续走":"正在等待"));
//                        cyclicBarrier.await();
//
//                        Thread.sleep(new Random().nextInt(10000));
//                        System.out.println("线程"+Thread.currentThread().getName()+"即将到达2, 当前已有"+(cyclicBarrier.getNumberWaiting()+1)+"已经到达"+(cyclicBarrier.getNumberWaiting()==2?"都到齐了,继续走":"正在等待"));
//                        cyclicBarrier.await();
//
//                        Thread.sleep(new Random().nextInt(10000));
//                        System.out.println("线程"+Thread.currentThread().getName()+"即将到达3, 当前已有"+(cyclicBarrier.getNumberWaiting()+1)+"已经到达"+(cyclicBarrier.getNumberWaiting()==2?"都到齐了,继续走":"正在等待"));
//                        cyclicBarrier.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (BrokenBarrierException e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//            //每创建一个线程就加入线程池执行
//            executorService.execute(runnable);
//        }
        executorService.shutdown(); //执行完成后关闭线程池
    }

    public static class MyThread1 extends Thread {
        private CyclicBarrier cyclicBarrier;

        public MyThread1(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            super.run();
            try {
                //Thread.sleep(new Random().nextInt(10000));
                Thread.sleep(1000);
                String currentThreadName = Thread.currentThread().getName();
                int numberWaiting = cyclicBarrier.getNumberWaiting();
                System.out.println("线程"+currentThreadName+"即将到达1，当前已有"+(numberWaiting+1)+"已经到达"+(numberWaiting==2?"都到齐了，继续走":"正在等待"));
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MyThread2 extends Thread {
        private CyclicBarrier cyclicBarrier;

        public MyThread2(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public synchronized void start() {
            super.start();
            try {
                //Thread.sleep(new Random().nextInt(10000));
                Thread.sleep(1000 * 2);
                String currentThreadName = Thread.currentThread().getName();
                int numberWaiting = cyclicBarrier.getNumberWaiting();
                System.out.println("线程"+currentThreadName+"即将到达2, 当前已有"+(numberWaiting+1)+"已经到达"+(numberWaiting==2?"都到齐了,继续走":"正在等待"));
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MyThread3 extends Thread {
        private CyclicBarrier cyclicBarrier;

        public MyThread3(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public synchronized void start() {
            super.start();
            try {
                //Thread.sleep(new Random().nextInt(10000));
                Thread.sleep(1000 * 3);
                String currentThreadName = Thread.currentThread().getName();
                int numberWaiting = cyclicBarrier.getNumberWaiting();
                System.out.println("线程"+currentThreadName+"即将到达3, 当前已有"+(numberWaiting+1)+"已经到达"+(numberWaiting==2?"都到齐了,继续走":"正在等待"));
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
