package com.frc.entity;

public class PersonVo {
    public PersonVo(String name, int age, String en){
        this.name = name;
        this.age = age;
        this.language = language;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String name;

    private int age;

    private String language;

    @Override
    public String toString() {
        return "PersonVo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", language='" + language + '\'' +
                '}';
    }
}
