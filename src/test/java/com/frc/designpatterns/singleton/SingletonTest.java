package com.frc.designpatterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    void getInstance() {
        Singleton  singleton1 = new Singleton().getInstance();
        Singleton singleton2 = new Singleton().getInstance();
        assertEquals(singleton1,singleton2);
    }
}