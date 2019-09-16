package com.javase.study.Math;

/**
 * java.util.Math类是数学相关的工具类，里面提供有大量的静态方法，完成数学运算相关操作
 * public static double abs(double num):获取绝对值。
 * public static double ceil(double num):向上取整。
 * public static double floor(double num):向下取整。
 * public static long round(double num):四舍五入。
 */
public class Test_Math {
    public static void main(String[] args) {
        //获取绝对值
        System.out.println( Math.abs( 3.14 ) );
        System.out.println( Math.abs( 0 ) );
        System.out.println( Math.abs( -2.5 ) );

        //向上取整
        System.out.println( Math.ceil( -2.5 ) );
        System.out.println( Math.ceil( 3.1 ) );
        System.out.println( Math.ceil( 2.9 ) );

        //向下取整
        System.out.println( Math.floor( 30.1 ) );
        System.out.println( Math.floor( 30.9 ) );
        System.out.println( Math.floor( -2.5 ) );

        //四舍五入
        System.out.println( Math.round( -1.8 ) );
        System.out.println( Math.round( 2.5 ) );
        System.out.println( Math.round( 1.1 ) );

        //返回两个数的最大值
        System.out.println( Math.max( 10.5, 11.2 ) );

        //返回两个数的最小值
        System.out.println( Math.min( 16, 19 ) );

        //返回a的b次幂的值
        System.out.println( Math.pow( 10, 2 ) );


    }
}
