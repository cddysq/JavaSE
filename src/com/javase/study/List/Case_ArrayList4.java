package com.javase.study.List;

import java.util.ArrayList;
import java.util.Random;

/**
 * 用一个大集合存入20个随机数字，然后筛选其中的偶数元素，放到小集合中。
 * 要求使用自定义的方法实现筛选。
 */
public class Case_ArrayList4 {
    public static void main(String[] args) {
        ArrayList<Integer> bigList = new ArrayList<>();
        Random r = new Random();

        //将生成的随机数放入大集合中
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt( 100 ) + 1;
            bigList.add( num );
        }

        //获取小集合元素遍历输出
        ArrayList<Integer> smaillList = getSmallList( bigList );
        System.out.println( "集合的总个数为：" + smaillList.size() );
        for (int i = 0; i < smaillList.size(); i++) {
            System.out.println( smaillList.get( i ) );
        }
    }

    //这个方法用于接收大集合参数，返回小集合结果
    public static ArrayList<Integer> getSmallList(ArrayList<Integer> bigList) {
        //创建一个小集合，用来装偶数结果
        ArrayList<Integer> smallList = new ArrayList<>();
        for (int i = 0; i < bigList.size(); i++) {
            int num = bigList.get( i );
            //将遍历后的大集合进行条件筛选
            if (num % 2 == 0) {
                smallList.add( num );
            }
        }
        return smallList;
    }
}

