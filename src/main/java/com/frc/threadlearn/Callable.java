package com.frc.threadlearn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Callable implements java.util.concurrent.Callable<Integer>{


    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        try {
            Thread.sleep(1111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2;
    }

    public static void main(String[] args) throws  Exception{
        ExecutorService executor = Executors.newCachedThreadPool();
        Callable task = new Callable();
        Future<Integer> result = executor.submit(task);
        System.out.println(result.get());

    }

}