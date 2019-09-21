package com.javase.study.Extends;

/**
 * Super关键字用来访问父类内容，而this关键字用来访问本类内容。
 * 1.在本类的成员方法中，访问本类的成员变量。
 * 2.在本类的成员方法中，访问本类的另一个成员方法。
 * 3.在本类的构造方法中，访问本类的另一个构造方法。
 * 在第三种用法当中要注意：
 * A.this(...)调用也必须是构造方法的第一个语句，唯一一个。
 * B.super和this两种构造调用，不能同时使用。
 */
public class ThisZi extends SuperFu {

    int num = 20;

    public ThisZi() {
        this( 123 );
    }

    public ThisZi(int n) {
        this( 1, 2 );
    }

    public ThisZi(int n, int m) {

    }

    public void showNum() {
        int num = 10;
        //局部变量
        System.out.println( num );
        //本类的成员变量
        System.out.println( this.num );
        //父类的成员变量
        System.out.println( super.num );
    }

    public void methodA() {
        System.out.println( "AAA" );
    }

    public void methodB() {
        this.methodA();//访问另一个成员方法
        System.out.println( "BBB" );

    }

}
