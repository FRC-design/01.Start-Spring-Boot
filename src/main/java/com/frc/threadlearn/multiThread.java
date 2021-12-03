package com.frc.threadlearn;


public class multiThread {
    private static volatile int flag = 0;


    public static class ThreadA implements Runnable{


        @Override
        public void run() {
            while(flag <5){
                if(flag %2 ==0){
                    System.out.println("threadA" + flag);
                    flag ++;
                }
            }
        }
    }

    public static class ThreadB implements Runnable{

        @Override
        public void run() {
            while(flag<5){
                if(flag%2 ==1){
                    System.out.println("threadB" +flag );
                    flag++;
                }
            }

        }
    }



    /**
     * 悲观锁lock
     */
//    public  synchronized void test1(){
//
//        ReentrantLock lock = new ReentrantLock();
//
//        public void modifyPublicResource() {
//            lock.lock();
//            lock.unlock();
//        }
//
//    }

    /**
     * 乐观锁lock
     */
//    public void teat2(){
//        //需保证多个线程使用同一个atomicInteger
//        AtomicInteger atomicInteger = new AtomicInteger();
//        //自增
//        atomicInteger.incrementAndGet();
//    }






    public static void main(String[] args) throws InterruptedException{
//        new Thread(new ThreadA()).start();
//        Thread.sleep(1111);
//        new Thread(new ThreadB()).start();

         Thread t1 = new Thread(()->
         {
             try {
                 Thread.sleep(21);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         });
         t1.start();

         t1.interrupt();



        Thread.sleep(111);
        t1.setDaemon(true);
        Boolean ted = t1.isInterrupted();
        System.out.println(ted);

        }







    }
