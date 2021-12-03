package com.frc.threadlearn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class printByOrderCondition {
    private int num = 1;
    private Lock LOCK = new ReentrantLock();;
    private final Condition condition1, condition2, condition3;


    public printByOrderCondition() {
        condition1 = LOCK.newCondition();
        condition2 = LOCK.newCondition();
        condition3 = LOCK.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        LOCK.lock();
        try{
            while(num != 1){
                condition1.await();
            }
            printFirst.run();
            num = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        LOCK.lock();
        try{
            while(num != 2){ condition2.wait();}
            printSecond.run();
            num = 3;
            condition3.signal();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        LOCK.lock();
        try{
            while(num!=3)
            {condition3.wait();}
            printThird.run();
            num = 1;
            condition1.signal();
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }
}
