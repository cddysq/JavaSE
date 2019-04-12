package com.java.study.Object;

/**
 *toString直接打印的是对象的地址值，打印对象属性，需要进行重写
 */
public class Test_ToString {
    public static void main(String[] args) {
        Person person = new Person( "荒荒",18 );
        String s = person.toString();
        System.out.println(s);
    }
}
