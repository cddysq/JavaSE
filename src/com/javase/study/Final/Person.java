package com.javase.study.Final;


public class Person {
    private final String name = "微凉";//final修饰需要赋值
    private int age;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
