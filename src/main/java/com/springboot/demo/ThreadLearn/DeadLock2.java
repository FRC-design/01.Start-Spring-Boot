package com.springboot.demo.ThreadLearn;

import java.util.concurrent.locks.ReentrantLock;

/**
 *  Oracle official Concurrent tutorial:
 *  https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html
 *
 *  deadlock with reentrant Lock, and solution
 *  https://my.oschina.net/u/2307589/blog/1832862
 * */
class Deadlock2 {
    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();

    public void methodA() {
        lock1.lock();
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock2.lock();
        // do something and unlock both.
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock1.unlock();
            lock2.unlock();
        }
    }

    public void methodB() {
       lock2.lock();
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock1.lock();
        try{
            // do something and unlock both.
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock2.unlock();
            lock1.unlock();
        }
    }

    public static void main(String[] args) {
        Deadlock2 instance = new Deadlock2();
        //调用A拿到锁1等锁2， B拿到锁2等锁1
        new Thread(instance::methodA).start();
        // new Thread(()->{instance.methodB(); }).start();
        new Thread(instance::methodB).start();
    }
}