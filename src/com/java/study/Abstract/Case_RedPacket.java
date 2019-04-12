package com.java.study.Abstract;

import java.util.ArrayList;

/**
 * 发红包案例
 */
public class Case_RedPacket {
    public static void main(String[] args) {
        Manager manager = new Manager("群主", 100);

        Member one = new Member("琳琳", 0);
        Member two = new Member("叶迟荒", 0);
        Member three = new Member("荒三岁", 0);

        manager.show();
        one.show();
        two.show();
        three.show();
        System.out.println("=========================");

        //群主总共发20块钱，分成3个红包
        ArrayList<Integer> redList = manager.send(20, 3);
        //三个普通成员收红包
        one.receive(redList);
        two.receive(redList);
        three.receive(redList);

        manager.show();
        one.show();
        two.show();
        three.show();

    }
}
