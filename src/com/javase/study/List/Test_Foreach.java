package com.javase.study.List;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 增强for循环：底层使用的也是迭代器，使用for循环的格式，简化迭代器的书写
 * JDK1.5之后加入
 * 用于遍历集合和数组，格式：
 * for(集合/数组的数据类型 变量名:集合名/数组名){
 * sout(变量名);
 * }
 */
public class Test_Foreach {
    public static void main(String[] args) {
        for1();
        for2();

    }

    //增强for循环遍历数组
    private static void for1() {
        int[] num = {1, 2, 3, 4, 5};
        for (int i : num) {
            System.out.println( i );
        }
    }

    //增强for循环遍历集合
    private static void for2() {
        Collection<String> coll = new ArrayList<>();
        coll.add( "萝卜" );
        coll.add( "青菜" );
        coll.add( "飘儿白" );
        coll.add( "豆尖" );
        for (String s : coll) {
            System.out.println( s );
        }
    }
}
