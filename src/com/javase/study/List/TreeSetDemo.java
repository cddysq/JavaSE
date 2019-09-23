package com.javase.study.List;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author：Haotian
 * @Date：2019/9/23 9:50
 * TreeSet
 * 可以对set集合中的元素进行排序，默认按照asic码表的自然顺序排序
 * 之所以treeset能排序是因为底层是二叉树，数据越多越慢,TreeSet是依靠TreeMap来实现的
 * TreeSet中存储自定义对象需要实现comparable接口
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        //实现不重复随机数
        Random random = new Random();
        //利用set不重复特性
        Set<Integer> set = new TreeSet<>();
        //存10个随机数
        while (set.size() < 10) {
            int number = random.nextInt( 20 ) + 1;
            set.add( number );
        }
        set.forEach( System.out::println );
    }
}
