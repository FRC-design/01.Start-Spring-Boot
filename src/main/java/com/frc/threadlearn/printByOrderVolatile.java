package com.frc.threadlearn;


public class printByOrderVolatile {

    private volatile int flag = 0;

    public void first(Runnable printFirst) throws InterruptedException {
        while(flag != 0){}
        printFirst.run();
        flag = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(flag != 1){}
        printSecond.run();
        flag = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(flag != 2){}
        printThird.run();
        flag = 0;
    }

}
