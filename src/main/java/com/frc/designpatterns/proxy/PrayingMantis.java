package com.frc.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author frc
 */
public class PrayingMantis implements InvocationHandler {

    private BaseService baseService;

    // 这里采用的是构建传参数，可以用反射，举的第一个例子有样式代码
    public PrayingMantis(BaseService baseService) {
        this.baseService = baseService;
    }

    // 螳螂主要业务，也就是监听对象
    @Override
    public Object invoke(Object listener, Method method, Object[] args) throws Throwable {
        method.invoke(baseService, args);
        secondaryMain();
        return null;
    }



    // 这里理解增强业务，即我们可以在实现InvocationHandler里面添加其他的业务，比如日志等等。
    private void secondaryMain(){
        System.out.println("螳螂捕蝉 - 次要业务");
    }

}