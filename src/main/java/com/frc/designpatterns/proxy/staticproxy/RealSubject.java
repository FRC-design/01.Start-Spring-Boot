package com.frc.designpatterns.proxy.staticproxy;

public class RealSubject implements  Subject{
    // 真实对象
    @Override
    public void doSomething() {
        System.out.println("放学去打游戏");
    }
}
