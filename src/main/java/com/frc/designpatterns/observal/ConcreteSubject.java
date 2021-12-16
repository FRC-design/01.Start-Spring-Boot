package com.frc.designpatterns.observal;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ConcreteSubject implements Subject{
    Observable container = new Observable();
    List<Observer> container1 = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        container1.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        container1.remove(observer);
    }

    @Override
    public void notifyObserver1(String message) {
        container.notifyObservers(message);
    }

    @Override
    public void notifyObserver2(String message) {
        for (Observer observer : container1) {
            observer.update(message);
        }
    }
}
