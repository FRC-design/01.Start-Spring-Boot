package com.frc.multithread;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * 信号量，限流器
 * @param <T>
 * @param <R>
 */

class ObjPool<T, R> {
    private  final List<T> pool;
    private final Semaphore sem;

    // 构造函数
    ObjPool(int size, T t){
        pool = new ArrayList<T>(){};
        for(int i=0; i<size; i++){
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    // 利用对象池的对象，调用 func
    R exec(Function<T,R> func) throws InterruptedException {
        T t = null;
        sem.acquire();
        try {
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            pool.add(t);
            sem.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ObjPool<Long, String> pool = new ObjPool<Long, String>(10, 2L);

        // 通过对象池获取 t，之后执行
        pool.exec(t -> {
            System.out.println(t);
            return t.toString();
        });
    }
}
