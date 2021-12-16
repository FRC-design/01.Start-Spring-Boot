package com.frc.designpatterns.singleton;

public class Singleton {
    private volatile static Singleton instance = null;
    public static Singleton getInstance() {
        if(null == instance) {
            synchronized (Singleton.class) {
                if(null == instance) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}