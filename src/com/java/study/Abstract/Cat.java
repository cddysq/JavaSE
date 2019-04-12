package com.java.study.Abstract;


public class Cat extends Animal {
    public Cat() {
        //super();抽象方法中要想调用父类构造方法，需要使用子类构造进行调用。
        System.out.println("子类构造方法执行！");
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
