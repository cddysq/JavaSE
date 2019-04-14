package com.javase.study.Abstract;

/**
 * 发红吧案例用户类
 */
public class User {
    private String nane;//姓名
    private int money;//余额，也就是用户拥有的钱数

    public User() {
    }

    public User(String nane, int money) {
        this.nane = nane;
        this.money = money;
    }

    public void show() {
        System.out.println("我叫：" + nane + "，我有" + money + "块钱。");
    }

    public String getNane() {
        return nane;
    }

    public void setNane(String nane) {
        this.nane = nane;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
