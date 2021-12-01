package com.springboot.demo.DesignPatterns.Stratege1;

public class OrderItemShare implements ShareStrategy{
    @Override
    public void algorithm(String param) {
        System.out.println("you are sharing what type"+ param);
    }
}
