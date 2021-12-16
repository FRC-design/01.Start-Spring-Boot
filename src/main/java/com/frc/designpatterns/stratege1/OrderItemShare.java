package com.frc.designpatterns.stratege1;

public class OrderItemShare implements ShareStrategy{
    @Override
    public void algorithm(String param) {
        System.out.println("you are sharing what type"+ param);
    }
}
