package com.javase.study.List;

import java.util.ArrayList;

/**
 * ArrayList集合的长度是可以随意变化的。（查询快，增删慢，底层使用的数组）
 * 对于ArrayList来说，有一个尖括号<E>表示泛型
 * 泛型：也就是装在集合里面的所有元素，全部是统一什么类型。
 * 注意：泛型只能是引用类型，不能是基本类型。
 * <p>
 * 注意事项：
 * ArrayList集合直接打印的是内容不是地址，空内容为：[]
 */
public class Test_ArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println( "空集合为=" + list );

        //向集合中添加元素：add方法。
        list.add( "琳琳" );
        list.add( "荒荒" );
        System.out.println( "第一次添加数据为：" + list );

        list.add( "叶迟荒" );
        list.add( "秦岭秋风" );
        list.add( "且听风吟" );
        System.out.println( "第二次添加数据为：" + list );

        System.out.println( "==========================" );
        //从集合中获取元素：get方法。索引值从0开始。
        String name = list.get( 2 );
        System.out.println( "第二号索引值位置：" + name );

        System.out.println( "==========================" );
        //从集合中删除元素：remove方法。索引值从0开始。、
        String remove = list.remove( 3 );
        System.out.println( "被删除的人是：" + remove );
        System.out.println( list );

        System.out.println( "==========================" );
        int size = list.size();
        System.out.println( "集合的长度是：" + size );

        System.out.println( "==========================" );
        System.out.println( "集合中的元素为：" );
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println( list.get( i ) );
        }
    }
}
