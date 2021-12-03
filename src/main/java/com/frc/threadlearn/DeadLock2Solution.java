package com.frc.threadlearn;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DeadLock1 {

    private static final Lock LOCK1 = new ReentrantLock();
    private static final Lock LOCK2 = new ReentrantLock();

    public static void deathLock() {
        new Thread(() -> {
            while (true) {
                if (LOCK1.tryLock()) {
                    try {
                        //如果获取成功则执行业务逻辑，如果获取失败，则释放lock1的锁，自旋重新尝试获得锁
                        if (LOCK2.tryLock()) {
                            try {
                                System.out.println("Thread1：已成功获取 lock1 and lock2 ...");
                                break;
                            } finally {
                                LOCK2.unlock();
                            }
                        }
                    } finally {
                        LOCK1.unlock();
                    }
                }
                System.out.println("Thread1：获取锁失败，重新获取---");
                try {
                    //防止发生活锁
                    TimeUnit.NANOSECONDS.sleep(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                if (LOCK2.tryLock()) {
                    try {
                        //如果获取成功则执行业务逻辑，如果获取失败，则释放lock2的锁，自旋重新尝试获得锁
                        if (LOCK1.tryLock()) {
                            try {
                                System.out.println("Thread2：已成功获取 lock2 and lock1 ...");
                                break;
                            } finally {
                                LOCK1.unlock();
                            }
                        }
                    } finally {
                        LOCK2.unlock();
                    }
                }
                System.out.println("Thread2：获取锁失败，重新获取---");
                try {
                    //防止发生活锁
                    TimeUnit.NANOSECONDS.sleep(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            deathLock();
        }
    }
}
