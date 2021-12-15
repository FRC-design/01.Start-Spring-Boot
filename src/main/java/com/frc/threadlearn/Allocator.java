package com.frc.threadlearn;

import java.util.HashSet;
import java.util.Set;

/**
 * Allocator 同时申请转出账户和转入账户这两个资源，成功后再锁定这两个资源；
 * 当转账操作执行完，释放锁之后，我们需通知 Allocator 同时释放转出账户和转入账户这两个资源
 *
 * 破坏占用且等待条件， 可以一次性申请所有资源
 * 破坏循环等待条件，对资源进行排序，然后按序申请资源。
 */
//相当于临界区，规避死锁
public class Allocator {
    //单例设计模式的饿汉式
    static private final Allocator instance = new Allocator();
    private Set<Object> res = new HashSet<>();

    public static Allocator getInstance() {
        return instance;
    }

    public synchronized void getLock(Object from, Object to) {
        while (res.contains(from) || res.contains(to)) {
            try {
                //将不满足条件的线程阻塞，加入等待的队列
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        res.add(from);
        res.add(to);
    }

    public synchronized void releaseLock(Object from, Object to) {
        res.remove(from);
        res.remove(to);
        //唤醒队列中所有等待的线程
        notifyAll();
    }
}

