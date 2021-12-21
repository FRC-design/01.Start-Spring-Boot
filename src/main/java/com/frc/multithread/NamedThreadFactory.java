package com.frc.multithread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author frc
 */
public class NamedThreadFactory implements ThreadFactory {

     static final AtomicInteger POOL_SEQ = new AtomicInteger(1);
     final AtomicInteger mThreadNum = new AtomicInteger(1);
     final String mPrefix;
     final boolean mDaemon;
     final ThreadGroup mGroup;

    public NamedThreadFactory(String mPrefix, boolean mDaemon, ThreadGroup mGroup) {
        this.mPrefix = mPrefix;
        this.mDaemon = mDaemon;
        this.mGroup = mGroup;
    }

    public NamedThreadFactory() {
        this("pool-" + POOL_SEQ.getAndIncrement(), false);
    }

    public NamedThreadFactory(String prefix) {
        this(prefix, false);
    }

    public NamedThreadFactory(String prefix, boolean daemon) {
        mPrefix = prefix + "-thread-";
        mDaemon = daemon;
        SecurityManager s = System.getSecurityManager();
        mGroup = (s == null) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = mPrefix + mThreadNum.getAndIncrement();
        Thread ret = new Thread(mGroup, r, name, 0);
        ret.setDaemon(mDaemon);
        return ret;
    }
}
