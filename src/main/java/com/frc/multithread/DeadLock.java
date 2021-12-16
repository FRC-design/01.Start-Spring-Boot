package com.frc.multithread;

/**
 * @author frc
*     死锁：两个线程持有锁，互相抢对方的锁
*     1.互斥，共享资源 X 和 Y 只能被一个线程占用；
*     2.占有且等待，线程 T1 已经取得共享资源 X，在等待共享资源 Y 的时候，不释放共享资源 X；
*     3.不可抢占，其他线程不能强行抢占线程 T1 占有的资源；
*     4.循环等待，线程 T1 等待线程 T2 占有的资源，线程 T2 等待线程 T1 占有的资源，就是循环等待。
 */
public class DeadLock {
    public static final Object LOCK1 = new Object();
    public static final Object LOCK2 = new Object();

    public static void main(String args[]) {
        new ThreadDemo1().start();
        new ThreadDemo2().start();

    }
    private static class ThreadDemo1 extends Thread {
        @Override
        public void run() {
            synchronized (LOCK1) {
                System.out.println("Thread 1: Holding lock 1...");
                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException e) {
                }
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (LOCK2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        @Override
        public void run() {
            synchronized (LOCK2) {
                System.out.println("Thread 2: Holding lock 2...");
                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException e) {

                }
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (LOCK1) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}