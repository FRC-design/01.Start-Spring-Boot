package com.springboot.demo.proxy;


public class printImp implements print{

    private  int num = 100;

    public printImp(int num) {
        this.num = num;
    }

    @Override
    public String print(String param) {
        return param;
    }
}
