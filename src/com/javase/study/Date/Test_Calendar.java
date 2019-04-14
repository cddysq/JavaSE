package com.javase.study.Date;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar抽象类，用于操作日历
 */
public class Test_Calendar {
    public static void main(String[] args) {
        demo();
        demo2();
    }

    private static void demo2() {
        //getTime()将日历转换为日期
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        System.out.println( date );
    }

    private static void demo() {
        //使用getInstance方法获取Calendar对象
        Calendar c = Calendar.getInstance();//多态

        //set设置年份
        c.set( Calendar.YEAR, 2060 );
        //set进行重载
        c.set( 1998, 10, 23 );

        //add增加或减少指定的值
        c.add( Calendar.DATE, 3 );
        c.add( Calendar.MONTH, -2 );

        //使用get获取需要的属性
        int year = c.get( Calendar.YEAR );
        System.out.println( "当前年份为：" + year );

        int month = c.get( Calendar.MONTH );
        System.out.println( "当前月份为：" + month );

        int date = c.get( Calendar.DATE );
        System.out.println( "当前为：第" + date + "天" );
    }
}
