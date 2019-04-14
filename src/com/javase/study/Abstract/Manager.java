package com.javase.study.Abstract;

import java.util.ArrayList;

/**
 * 群主的类
 */
public class Manager extends User {

    public Manager() {

    }

    public Manager(String nane, int money) {
        super(nane, money);
    }

    /**
     * @param totalMoney 红包发放金额
     * @param count      红包份数
     * @return
     */
    public ArrayList<Integer> send(int totalMoney, int count) {
        //首先需要一个集合，用来储存若干个红包的金额
        ArrayList<Integer> redList = new ArrayList<>();

        //首先看一下群主自己有多少钱
        int leftMoney = super.getMoney();//群主当前余额
        if (totalMoney > leftMoney) {
            System.out.println("余额不足");
            return redList;//返回空集合
        }
        //扣钱，其实就是重新设置余额
        super.setMoney(leftMoney - totalMoney);

        //发红包需要平均拆分成count份
        int avg = totalMoney / count;
        int mod = totalMoney % count;//余数，也就是甩下零头

        //除不开的零头，包在最后一个红包当中
        //下面把红包一个一个放在集合当中
        for (int i = 0; i < count - 1; i++) {
            redList.add(avg);
        }

        //最后一个红包
        int last = avg + mod;
        redList.add(last);
        System.out.println("成功给群员发红包：" + totalMoney);
        return redList;
    }
}
