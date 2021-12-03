package com.frc.threadlearn;

class FooBar {
    private final int n;
    private final static Object LOCK = new Object();
    private volatile boolean FOO_EXEC = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (LOCK) {
                if (!FOO_EXEC) {//fooExec为false时，该线程等待，为true的时候执行下面的操作
                    LOCK.wait();
                }
                printFoo.run();
                FOO_EXEC = false;
                LOCK.notifyAll();//唤醒其他线程
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (LOCK) {
                if (FOO_EXEC) {
                    LOCK.wait();
                }
                printBar.run();
                FOO_EXEC = true;
                LOCK.notifyAll();
            }

        }
    }
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);
        Thread foo = new Thread(()-> System.out.println("foo"));
        Thread bar = new Thread(()-> System.out.println("bar"));

        Thread t1 = new Thread(()->{
            try {
                fooBar.foo(foo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2= new Thread(()->{
            try {
                fooBar.bar(bar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

}
