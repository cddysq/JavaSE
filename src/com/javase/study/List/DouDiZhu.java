package com.javase.study.List;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 斗地主案例：无序版
 */
public class DouDiZhu {
    public static void main(String[] args) {
        /**
         *  1.准备牌
         *  定义一个储存54张牌的ArrayList集合
         */
        ArrayList<String> poker = new ArrayList<>();
        //定义两个数组，一个数组储存花色，一个数组储存牌的序号
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        //先把大王小王存储到poker集合中
        poker.add( "大王" );
        poker.add( "小王" );
        //循环嵌套遍历两个数组，组装52张牌
        for (String color : colors) {
            for (String number : numbers) {
                //把遍历好的牌储存到poker集合中
                poker.add( color + number );
            }
        }
        //System.out.println(poker);
        /**
         * 2.洗牌
         *使用集合的工具类Collections中的方法
         * static void shuffle(List<?> list)使用默认的随机源对指定列表进行置还
         */
        Collections.shuffle( poker );

        /**
         * 3.发牌
         * 定义四个集合，储存玩家的牌和底牌
         */
        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();
        /**
         * 遍历poker集合，获取每一张牌
         * 使用poker集合的索引%3给三个玩家轮流发牌
         * 剩余三张牌给底牌
         * 注意：
         * 先判断底牌（i >=51），否者牌发完，无底牌
         */

        for (int i = 0; i < poker.size(); i++) {
            //获取每一张牌
            String p = poker.get( i );
            //轮流发牌
            if (i >= 51) {
                //发底牌
                diPai.add( p );
            } else if (i % 3 == 0) {
                //给玩家一发牌
                player01.add( p );
            } else if (i % 3 == 1) {
                //给玩家二发牌
                player02.add( p );
            } else if (i % 3 == 2) {
                //给玩家三发牌
                player03.add( p );
            }
        }
        //4.看牌
        System.out.println( "叶迟荒：" + player01 );
        System.out.println( "听风吟：" + player02 );
        System.out.println( "往三生：" + player03 );
        System.out.println( "底牌：" + diPai );
    }
}