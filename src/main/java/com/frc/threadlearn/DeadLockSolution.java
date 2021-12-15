package com.frc.threadlearn;

/**
 * @author frc
 */
public class DeadLockSolution {
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
                } catch (InterruptedException e) {}
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
            synchronized (LOCK1) {
                System.out.println("Thread 2: Holding lock 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 2...");

                synchronized (LOCK2) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
}