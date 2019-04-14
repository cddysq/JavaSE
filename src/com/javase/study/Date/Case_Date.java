package com.javase.study.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 使用日期相关的API，计算出一个人出生了多少天
 * 分析：
 * 1.使用scanner，获取出生日期
 * 2.使用DateFormat类中的parse方法，把出生日期解析为Date格式日期
 * 3.把Date格式的出生日期转换为毫秒值
 * 4.获取当前的日期，转换为毫秒值
 * 5.使用当前日期的毫秒值 - 出生日期的毫秒值
 * 6.把毫秒值转换为天(S/1000/60/60/24)
 */
public class Case_Date {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "请输入您的出生日期，格式：yyyy-MM-dd" );
        //获取出生日期
        String birthdayDateString = scanner.next();
        //将字符串日期按照对应格式，使用parse进行转化为Date
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        Date birthdayDate = sdf.parse( birthdayDateString );
        //把Date格式出生日期转化为毫秒值
        long birthdayDateTime = birthdayDate.getTime();
        //获取当前日期转化为毫秒值
        long todayTime = new Date().getTime();
        //计算出生时间
        long time = todayTime - birthdayDateTime;
        //转化为天数进行输出打印
        System.out.println( "您已经出生了" + time / 1000 / 60 / 60 / 24 + "天" );

    }
}
