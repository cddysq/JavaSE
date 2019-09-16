package com.javase.study.Date;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Calendar抽象类，用于操作日历
 */
public class Test_Calendar {
    public static void main(String[] args) {
        demo();
        demo2();
        Scanner scanner = new Scanner( System.in );
        System.out.println( "请输入要查询的年份：" );
        int i = scanner.nextInt();
        februaryDay( i );
    }

    private static void demo2() {
        //getTime()将日历转换为日期
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        System.out.println( date );
    }

    private static void demo() {
        //使用getInstance方法获取Calendar对象,多态
        Calendar c = Calendar.getInstance();

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

    /**
     * 二月天，输入一个年份求二月的天数
     */
    private static void februaryDay(Integer year) {
        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        //通过三月份减去一天得出二月份天数
        calendar.set( year, 2, 1 );
        calendar.add( Calendar.DATE, -1 );
        //获取当前的天数
        int day = calendar.get( Calendar.DATE );
        System.out.println( year + "年的二月份有" + day + "天" );
    }
}
