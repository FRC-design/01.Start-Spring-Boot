package com.springboot.demo.ThreadLearn;

import java.util.concurrent.locks.ReentrantLock;

public class lock {
    public static void main(String[] args) {
        lock lock1 = new lock();
        lock1.run();

    }
    public ReentrantLock locker = new ReentrantLock();
    private void run(){
        locker.lock();
        try {
            locker.lock();
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
