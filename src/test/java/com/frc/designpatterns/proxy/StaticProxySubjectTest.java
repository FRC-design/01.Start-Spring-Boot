package com.frc.designpatterns.proxy;

import com.frc.designpatterns.proxy.staticproxy.RealSubject;
import com.frc.designpatterns.proxy.staticproxy.StaticProxySubject;
import org.junit.jupiter.api.Test;

class StaticProxySubjectTest {

    @Test
    void staticProxy(){
        try {
            // 第一种方式
            new StaticProxySubject().doSomething();
            // 打印结果： 放学去打游戏
        } catch (Exception e) {
            // 异常情况，代理失败，
            // 传纸条的被老师抓了。或者同学C不在座位上了 等异常情况
        }

        // 第二种方式
        new StaticProxySubject(new RealSubject()).doSomething();
        // 打印结果： 放学去打游戏
    }

}