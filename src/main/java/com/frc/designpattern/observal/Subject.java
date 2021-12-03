package com.frc.designpattern.observal;

public interface Subject {


    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObserver1(String message);


    void notifyObserver2(String message);
}
