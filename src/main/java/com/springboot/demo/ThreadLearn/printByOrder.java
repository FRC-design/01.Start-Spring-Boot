package com.springboot.demo.ThreadLearn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class printByOrder {
    public static void main(String[] args) {
        Foo1 foo = new Foo1();
        Thread first = new Thread(()->{ System.out.println("first"); });
        Thread second = new Thread(()->{ System.out.println("second"); });
        Thread third = new Thread(()->{ System.out.println("third"); });

        Thread t1= new Thread(()->{
            try {
                foo.first(first);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                foo.second(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()->{
            try {
                foo.third(third);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
class Foo {
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
class Foo1{
        int num;
        Lock lock;
        Condition condition1, condition2, condition3;
        public Foo1() {
            num = 1;
            lock = new ReentrantLock();
            condition1 = lock.newCondition();
            condition2 = lock.newCondition();
            condition3 = lock.newCondition();
        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
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
                lock.unlock();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try{
                while(num != 2){ condition2.wait();}
                printSecond.run();
                num = 3;
                condition3.signal();
            }catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try{
                while(num!=3){condition3.wait();}
                printThird.run();
                num = 1;
                condition1.signal();
            }catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }