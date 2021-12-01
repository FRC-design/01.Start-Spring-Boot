package com.springboot.demo.ThreadLearn;

class FooBar {
    private int n;
    private Object obj = new Object();
    private volatile boolean fooExec = true;
    public FooBar(int n) {
        this.n = n;
    }
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (obj) {
                if (!fooExec) {//fooExec为false时，该线程等待，为true的时候执行下面的操作
                    obj.wait();
                }
                printFoo.run();
                fooExec = false;
                obj.notifyAll();//唤醒其他线程
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (obj) {
                if (fooExec) {
                    obj.wait();
                }
                printBar.run();
                fooExec = true;
                obj.notifyAll();
            }

        }
    }
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);
        Thread foo = new Thread(()->{ System.out.println("foo"); });
        Thread bar = new Thread(()->{ System.out.println("bar"); });

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

    class FooBar1 {
        private int n;
        private Object obj = new Object();
        private volatile boolean fooExec = true;
        public FooBar1(int n) {
            this.n = n;
        }




        }
}
