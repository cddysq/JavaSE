package com.java.study.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * java.util.Iterator接口：迭代器（对集合进行遍历）
 * 使用步骤：
 * 1.使用集合中的iterator()获取迭代器的实类对象，使用Iterator接口接收（多态）
 * 2.使用Iterator接口中的boolean hasNext(),判断有没有下一个元素，有则继续迭代
 * 3.使用Iterator接口中的E next()，取出集合中的下一个元素
 */
public class Test_Iterator {
    public static void main(String[] args) {
        //创建一个集合
        Collection<String> coll = new ArrayList<>();

        //添加元素
        coll.add( "香蕉" );
        coll.add( "苹果" );
        coll.add( "水蜜桃" );
        coll.add( "葡萄" );
        coll.add( "芒果" );

        //创建一个迭代器对象
        Iterator<String> it = coll.iterator();

        //遍历集合
        while (it.hasNext()) {//判断集合中还有没有下一个元素
            String next = it.next();//取出下一个元素，并把指针向后移动一位
            System.out.println( next );
        }

    }
}
