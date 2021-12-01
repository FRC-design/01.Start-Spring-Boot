package com.springboot.demo.ThreadLearn;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 创建线程或线程池需要定义有意义的线程名称
 */

public class ThreadPool  implements ThreadFactory {
    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger();

// 定义线程组名称，线程排查有帮助
    ThreadPool(String whatFeatureOfGroup){
        namePrefix = "From UserThreadFactory" + whatFeatureOfGroup + "-worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndDecrement();
        Thread thread = new Thread(null,task, name,0);
        System.out.println(thread.getName());
        return thread;

    }


    public static void main(String[] args){


    }
}
