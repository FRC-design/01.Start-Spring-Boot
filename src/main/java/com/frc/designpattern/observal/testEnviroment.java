package com.frc.designpattern.observal;

public class testEnviroment {
    public static void main(String[] args) {
        //publisher&container
        ConcreteSubject subject = new ConcreteSubject();
        Observer1 observer1 = new Observer1();
        Observer1 observer2 = new Observer1();

        subject.attach(observer1);
        subject.attach(observer2);

        subject.notifyObserver2("publish MSG, o1 o2 get MSG");

        subject.detach(observer2);
        subject.notifyObserver2("publish MSG, only o1 gets MSG");
    }
}
