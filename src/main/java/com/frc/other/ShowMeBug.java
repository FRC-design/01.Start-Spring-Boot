package com.frc.other;


import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 100个线程向一个账户转1元
 */

public class ShowMeBug {
    // 账户余额
    private double balance;
    private Lock lock = new ReentrantLock();

    public ShowMeBug(double balance) {
        this.balance = balance;
    }

    public void deposit(double money) {
        lock.lock();
        try{

            balance = balance + money;
        }finally {
            lock.unlock();
        }

    }

    public double getBalance() {
        return balance;
    }


    static class  SingleMoney implements Runnable{
        private ShowMeBug account;
        private double money;

        public SingleMoney(ShowMeBug account, double money){
            this.account = account;
            this.money = money;
        }
        @Override
        public void run(){
            account.deposit(money);
        }
    }

    public static void main(String[] args) {
        ShowMeBug account = new ShowMeBug(0);

        //todo:100线程并发
        ExecutorService pool = Executors.newFixedThreadPool(100);
        for(int i = 0; i< 100; i++){
            pool.execute(new SingleMoney(account, 1));
        }
        pool.shutdown();
        while(!pool.isTerminated()) {}
        System.out.println("账户余额: " + account.getBalance());
    }


}