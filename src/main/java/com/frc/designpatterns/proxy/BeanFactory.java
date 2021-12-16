package com.frc.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author frc
 */
public class BeanFactory {

    public static BaseService newInstanc(Class classFile) {
        // 1. 创建蝉，真实类对象
        BaseService trueCicada = new Cicada();
        // 2.创建代理类 螳螂
        InvocationHandler prayingMantis = new PrayingMantis(trueCicada);
        // 3.向Jvm索要代理对象 其实就是监听的对象，
        Class classArray[] = {BaseService.class};
        BaseService baseService = (BaseService) Proxy.newProxyInstance
                 (classFile.getClassLoader(), classArray, prayingMantis);
        return baseService;
    }
    // 测试Demo
    public static void main(String[] args) {
        BaseService baseService  = newInstanc(Cicada.class);
        baseService.mainService();
        // 测试结果 ：主要业务
        //           螳螂捕蝉 - 次要业务
    }
}