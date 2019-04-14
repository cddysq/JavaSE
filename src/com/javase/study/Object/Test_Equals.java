package com.javase.study.Object;

/**
 * equals用于进行对象比较，默认比较地址值，需要进行重写比较对象属性
 */
public class Test_Equals {
    public static void main(String[] args) {
        Person p1 = new Person( "琳琳", 18 );
        Person p2 = new Person( "琳琳", 18 );
        System.out.println(p1);
        System.out.println(p2);
        boolean b = p1.equals( p2 );
        System.out.println(b);
    }
}
