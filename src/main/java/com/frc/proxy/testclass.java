package com.frc.proxy;

import java.lang.reflect.*;

public class testclass {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class printClazz  = Proxy.getProxyClass(printImp.class.getClassLoader(), printImp.class.getInterfaces());

        Constructor constructor = printClazz.getConstructor(InvocationHandler.class);

        printImp printImp1 = (printImp)constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("shit");
                return null;
            }
        });

        print print11 = new print() {
            @Override
            public String print(String param) {
                return "goddam";
            }
        };

        
    }
}
