package com.frc.multithread;

import org.junit.jupiter.api.Test;


class printByOrderTest {

    private final Thread first = new Thread(()-> System.out.println("first"));
    private final Thread second = new Thread(()-> System.out.println("second"));
    private final Thread third = new Thread(()-> System.out.println("third"));

    @Test
    void printByOrderConditionTest(){
        printByOrderCondition foo = new printByOrderCondition();
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

    @Test
    void printByOrderVolatileTest(){
        printByOrderVolatile foo = new printByOrderVolatile();
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

//    @AfterEach
//    void printAfter(){
//        System.out.println("\n test finish");
//    }


}