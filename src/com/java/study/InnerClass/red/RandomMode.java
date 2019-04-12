package com.java.study.InnerClass.red;

import java.util.ArrayList;
import java.util.Random;

public class RandomMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();

        //随机分配，有可能多，有可能少
        //最少一分钱,最多不超过剩下金额平均数的两倍

        //范围公式：1 + random.nextInt(leftMoney / leftCount * 2)
        Random r = new Random();
        //totalMoney总金额，totalCount总份数，不变
        //定义两个变量。分别代表剩下多少钱，剩下多少份
        int leftMoney = totalMoney;
        int leftCount = totalCount;

        //随机发钱n-1个，最后一个不需要随机
        for (int i = 0; i < totalCount - 1; i++) {
            int money = r.nextInt( leftMoney / leftCount * 2 ) + 1;
            list.add( money );//将一个随机红包放入集合中
            leftMoney -= money;//剩下的金额越发越少
            leftCount--;//剩下还应该再发的红包个数，递减
        }

        //最后一个红包直接放入剩下的金额
        list.add( leftMoney );
        return list;
    }
}
