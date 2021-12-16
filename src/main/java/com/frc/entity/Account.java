package com.frc.entity;

import com.frc.multithread.Allocator;

/**
 * @author frc
 * 不能锁account.class 会串行化，并发很差
 * 去依次锁A B账户，容易造成死锁
 */
public class Account {
    private Integer balance;
    private Integer id;

    public Account(Integer id, Integer balance) {
        this.id = id;
        this.balance = balance;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "账号id " + id.toString() + "  余额 ￥" + balance.toString() + " ";
    }


    public void transactionToTarget(Integer money, Account target) {
        //获取锁
        Allocator.getInstance().getLock(this, target);
        System.out.println("转账开始--转出账号：" + this.toString() + "|转入账号：" + target.toString());
        if (this.balance - money >= 0) {
            this.balance -= money;
            target.setBalance(target.getBalance() + money);
            System.out.println("转账成功--转出账号：" + this.toString() + "|转入账号：" + target.toString());
        } else {
            System.out.println("转账失败--转出账号：" + this.toString() + "|想转金额：￥" + money.toString());
        }
        //释放锁
        Allocator.getInstance().releaseLock(this, target);
    }
}

