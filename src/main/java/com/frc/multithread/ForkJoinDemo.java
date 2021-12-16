package com.frc.multithread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * tradeoff : thread context switch
 */

public class ForkJoinDemo extends RecursiveTask<Integer> {
    private int i;

    public ForkJoinDemo(int i) {
        this.i = i;
    }

    /**
     * 斐波那契
     * @return
     */
    @Override
    protected Integer compute() {
        if(i<=1){
            return i;
        }else{
            ForkJoinDemo task1 = new ForkJoinDemo(i-1);
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo(i-2);
            task2.fork();
            return task1.join() + task2.join();
        }
    }

    public static void main(String[] args) {
        Long star_time = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(40);
        Future<Integer> result = pool.submit(task);
        System.out.println(result);
    }

}
