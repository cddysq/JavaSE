package com.java.study.Object;

import java.util.Objects;

//Object类为超类
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //重写toString获取属性
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        //判断是否为同一个对象
        if (this == o) return true;
        //getClass() != o.getClass())使用反射技术，判断o是否是person类型
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        //使用Objects防止空指针异常
        return age == person.age &&
                Objects.equals( name, person.name );
    }

    @Override
    public int hashCode() {
        return Objects.hash( name, age );
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
}
