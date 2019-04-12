package com.java.study.List;

import java.util.LinkedList;

/**
 * LinkedList集合特点：
 * 1.底层是一个链表结构：查询慢，增删快
 * 2.里边包含有大量操作首位元素的方法
 * 注意：使用LinkedList集合特有方法，不能使用多态
 * public void addFirst(E e):将指定元素插入此列表的开头。
 * public void addLast(E e):将指定元素插入此列表的结尾。
 * public void push(E e):将元素推入此列表所表示的堆栈。等效于addFirst
 * <p>
 * public E getFirst():返回此列表的第一个元素。
 * public E getLast():返回此列表的最后一个元素。
 * public E removeFirst():移除并返回此列表的第一个元素。
 * public E removeLast():移除并返回此列表的最后一个元素。
 * public E pop():从此列表所表示的堆栈处弹出一个元素。等效于removeFirst
 * public boolean isEmpty():如果列表不包含元素，则返回true。
 */
public class Test_LinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = show1();
        for (String s : list) {
            System.out.print( s );
        }
        System.out.println();
        show2();
        show3();
    }

    private static LinkedList<String> show1() {
        //添加
        LinkedList<String> list = new LinkedList<>();
        list.add( "a" );
        list.add( "b" );
        list.add( "c" );
        list.addFirst( "www." );
        list.addLast( ".com" );
        return list;
    }

    private static void show2() {
        //获取
        LinkedList<String> link = new LinkedList<>();
        link.add( "a" );
        link.add( "b" );
        link.add( "c" );
        System.out.println( link );
        //获取元素需先判断是否存在元素
        if (!link.isEmpty()) {
            System.out.println( "获取第一个元素：" + link.getFirst() );
            System.out.println( "获取最后一个元素：" + link.getLast() );
        }
    }

    private static void show3() {
        //移除
        LinkedList<String> link = show1();
        System.out.println( link );
        String first = link.removeFirst();
        String last = link.removeLast();
        System.out.println( "移除的第一个元素为：" + first );
        System.out.println( "移除的最后一个元素为：" + last );
    }
}
