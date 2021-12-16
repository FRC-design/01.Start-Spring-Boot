package com.frc.multithread;

import com.frc.entity.Account;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {
    static private final List<Account> accountList = new ArrayList<>();
    static final int testAccountNumber = 100;
    static final int testThreadNumber = 1000;
    static final CountDownLatch countDownLatch = new CountDownLatch(testThreadNumber);

    @Test
    void randomCheck() throws InterruptedException {
        //每个账户放100元,100个账户
        for (int i = 0; i < testAccountNumber; i++) {
            accountList.add(new Account(i,100));
        }
        //大量线程乱序转账
        for (int i = 0; i < testThreadNumber; i++) {
            new Thread(()->randomTransfer()).start();
        }

        countDownLatch.await();
        long totalNumber = 0;
        for (Account i : accountList) {
            if (i.getBalance() < 0) {
                return;
            }
            totalNumber += i.getBalance();
        }
        System.out.println("总余额： " + totalNumber);
        assertEquals(totalNumber, 10000);
    }

    private void randomTransfer() {
        Account account1 = accountList.get(ThreadLocalRandom.current().nextInt(testAccountNumber));
        Account account2 = accountList.get(ThreadLocalRandom.current().nextInt(testAccountNumber));
        account1.transactionToTarget(ThreadLocalRandom.current().nextInt(100),account2);
        countDownLatch.countDown();
    }
}
