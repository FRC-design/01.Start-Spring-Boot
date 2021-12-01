package com.springboot.demo.DesignPatterns.Singleton;

public class Singleton {
    public static class Singleton1{
        private static Singleton1 instance = new Singleton1();


        private Singleton1(){
        }

        public static Singleton1 getInstance(){
            return instance;
        }
    }

    public static class Singleton2{
        private static Singleton2 instance;


        private Singleton2(){
        }

        public static Singleton2 getInstance(){
            if(instance == null){
                instance = new Singleton2();
            }
            return instance;
        }
    }


    public static class Singleton3{
        private static Singleton3 instance;


        private Singleton3(){
        }

        public static synchronized Singleton3 getInstance(){
            if(instance == null){
                instance  = new Singleton3();
            }
            return instance;
        }
    }

    public static class Singleton4{

        private static Singleton4 instance;
        private Singleton4(){
        }

        public static  Singleton4 getInstance(){
            if(instance == null){
                synchronized (Singleton4.class){
                    if(instance == null){
                        instance  = new Singleton4();
                    }
                }

            }
            return instance;
        }
    }

    /**
     * 懒汉模式
     */

    public static class SingletonFinal{

        private volatile static  SingletonFinal instance = null;

        private SingletonFinal(){
        }

        public static  SingletonFinal getInstance(){
            if(instance == null){
                synchronized (Singleton4.class){
                    if(instance == null){
                        instance  = new SingletonFinal();
                    }
                }

            }
            return instance;
        }
    }

    /**
     *1. 内部类，JVM保证只创建一个
     *2. 枚举类，只创建一个
     */

}
