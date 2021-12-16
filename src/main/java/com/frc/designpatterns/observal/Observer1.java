package com.frc.designpatterns.observal;

public class Observer1 implements Observer {

    @Override
    public void update(String message) {
        System.out.println("something update!");
    }
}
