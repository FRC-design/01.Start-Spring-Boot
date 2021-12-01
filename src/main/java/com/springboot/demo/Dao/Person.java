package com.springboot.demo.Dao;

public class Person {

    public Person(String name, int age, String skin){
        this.name = name;
        this.age = age;
        this.skin = skin;
    }

    private String name;

    private int age;

    private String skin;

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public void name(String name) {
        this.name = name;
    }

    public String getname() {
        return name;
    }

    public void setBigPic(int age) {
        this.age = age;
    }

    public int getage() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skin='" + skin + '\'' +
                '}';
    }
}
