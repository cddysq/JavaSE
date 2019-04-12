package com.java.study.String;

/**
 * java.lang.StringBuilder:字符串缓冲区，可以提高字符串的效率,初始容量为16个字符
 * StringBuilder(String str)：构造一个字符串生成器，并初始化为指定字符串内容
 */
public class Test_StringBuilder {
    public static void main(String[] args) {
        StringBuilder bu1 = new StringBuilder();
        System.out.println( "bu1:" + bu1 );
        //使用append方法往StringBuilder中添加任意数据
        /**
         * 链式编程：方法返回值是一个对象，可以继续调用方法
         */
        bu1.append( "cdf" ).append( true ).append( 1 ).append( 8.8 ).append( '哎' );
        System.out.println( "bu1:" + bu1 );

        StringBuilder bu2 = new StringBuilder( "ABC" );
        System.out.println( "stu2:" + bu2 );

        //与String类型互相转换
        //String -> StringBuilder

        String str = "Hello ";
        System.out.println( "str:" + str );
        StringBuilder builder = new StringBuilder( str );
        builder.append( "World" );
        System.out.println( "builder:" + builder );

        //StringBuilder -> String
        String bs = builder.toString();
        System.out.println( "bs:" + bs );
    }
}
