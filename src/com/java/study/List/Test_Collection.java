package com.java.study.List;

import java.util.ArrayList;
import java.util.Collection;

/**
 * java.util.Collection接口
 * 为所有单列集合的最顶层接口，里面定义了所有单列集合的共性方法
 */
public class Test_Collection {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        System.out.println( "coll：" + coll );

        //public boolean add(E e):把给定的对象添加到当前集合中
        boolean add = coll.add( "迷途" );
        System.out.println( "add:" + add );
        System.out.println( "coll：" + coll );
        coll.add( "叶迟荒" );
        coll.add( "三岁" );
        coll.add( "听风吟酒" );
        System.out.println( "coll：" + coll );

        //public boolean remove(E e):把给定的对象在当前集合中删除
        boolean remove1 = coll.remove( "三岁" );
        boolean remove2 = coll.remove( "琳琳" );
        System.out.println( "remove1:" + remove1 );
        System.out.println( "remove2:" + remove2 );
        System.out.println( "coll：" + coll );

        //public boolean contains(E e):判断当前集合中是否包含给定的对象
        boolean contains = coll.contains( "迷途" );
        System.out.println( "contains:" + contains );

        //public boolean isEmpty():判断当前集合中是否为空
        boolean empty = coll.isEmpty();
        System.out.println( "empty:" + empty );

        //public int size():返回集合中的元素个数
        int size = coll.size();
        System.out.println( "size:" + size );

        //public object[] toArray():把集合中的元素，存储到数组中
        Object[] toArray = coll.toArray();
        for (int i = 0; i < toArray.length; i++) {
            System.out.println( toArray[i] );
        }

        //public void clear():清空集合中的所有元素，但不删除集合
        coll.clear();
        System.out.println( coll );
        System.out.println( coll.isEmpty() );


    }
}
