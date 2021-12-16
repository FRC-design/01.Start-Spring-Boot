package com.frc.designpatterns.proxy.staticproxy;

import java.lang.reflect.InvocationTargetException;

/**
 * @author frc
 */
public class StaticProxySubject implements Subject {

    private RealSubject realSubject;

    public StaticProxySubject()
            throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        this.realSubject = (RealSubject) this
                .getClass()
                .getClassLoader()
                .loadClass("com.frc.designpatterns.proxy.staticproxy.RealSubject")
                .getConstructor()
                .newInstance();
       // this.realSubject = new RealSubject();
    }

    public StaticProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }



    @Override
    public void doSomething() {
        realSubject.doSomething();
    }


}
