package com.javase.study.Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 斗地主案例：有序版
 */
public class DouDiZhu {
    public static void main(String[] args) {
        /**
         * 1.准备牌
         * 创建一个Map集合，储存牌的索引和组装好的牌
         */
        HashMap<Integer, String> poker = new HashMap<>();
        //创建一个集合储存牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //定义两个集合，储存牌的花色和序号
        List<String> colors = List.of( "♠", "♥", "♣", "♦" );
        List<String> numbers = List.of( "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3" );
        //先把大王小王储存到集合中
        //定义牌的索引
        int index = 0;
        poker.put( index, "大王" );
        pokerIndex.add( index );
        index++;
        poker.put( index, "小王" );
        pokerIndex.add( index );
        index++;
        //循环嵌套遍历两个集合，组装52张牌，储存到集合中
        for (String number : numbers) {//因为要排序，先添加数字
            for (String color : colors) {
                poker.put( index, color + number );
                pokerIndex.add( index );
                index++;
            }
        }
        /**
         * 2.洗牌
         * 使用Collections中的shuffle(List)方法
         */
        Collections.shuffle( pokerIndex );
        /**
         * 3.发牌
         * 定义四个集合，储存玩家牌的索引，和底牌的索引
         */
        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();
        //遍历储存牌索引的List集合，获取每一张牌的索引
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get( i );
            //先判断底牌
            if (i >= 51) {
                diPai.add( in );
            } else if (i % 3 == 0) {
                //给玩家一发牌
                player01.add( in );
            } else if (i % 3 == 1) {
                //给玩家二发牌
                player02.add( in );
            } else if (i % 3 == 2) {
                //给玩家三发牌
                player03.add( in );
            }
        }
        /**
         * 4.排序
         * 使用Collections中的sort(List)
         * 默认升序
         */
        Collections.sort( player01 );
        Collections.sort( player02 );
        Collections.sort( player03 );
        Collections.sort( diPai );

        lookPoker( "刘备", poker, player01 );
        lookPoker( "关羽", poker, player02 );
        lookPoker( "张飞", poker, player03 );
        lookPoker( "底牌", poker, diPai );
    }

    /**
     * 5.看牌
     * 定义一个看牌方法，提高可用性
     * 查表法：
     * 遍历玩家或者底牌集合，获取牌的索引
     * 使用牌的索引，去Map集合中，找到对应的牌
     */
    public static void lookPoker(String name, HashMap<Integer, String> poker, ArrayList<Integer> list) {
        //输出玩家名称
        System.out.println( name + "：" );
        //遍历玩家或底牌集合，获取牌的索引
        for (Integer key : list) {
            //使用牌的索引，去Map集合中，找到对应的牌
            String value = poker.get( key );
            System.out.print( value + " " );
        }
        System.out.println();//打印完每一个玩家进行换行
    }
}