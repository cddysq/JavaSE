package com.javase.study.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author：Haotian
 * @Date：2019/9/14 15:43
 */
public class DateUtil {
    private static final SimpleDateFormat SDF = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
    /**
     * ofPattern,使用指定的模式创建格式化程序。
     */
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm:ss" );


    private DateUtil() {
    }

    /**
     * 格式化日期，线程不安全
     *
     * @param data 时间
     * @return 格式化后的时间
     */
    public static String formatDate(Date data) {
        return SDF.format( data );
    }

    /**
     * 将符合条件的字符串转换为时间
     *
     * @param strDate 字符串
     * @return 转换后的时间
     * @throws ParseException
     */
    public static Date parse(String strDate) throws ParseException {
        return SDF.parse( strDate );
    }

    /**
     * 格式化日期，线程安全
     *
     * @param date 时间
     * @return 格式化后的时间
     */
    public static String formatDate(LocalDateTime date) {
        return DTF.format( date );
    }

    /**
     * 将符合规则的字符串转换为时间
     *
     * @param strDate 字符串
     * @return 转换后的时间
     */
    public static LocalDateTime parseTime(String strDate) {
        //public static LocalDateTime parse​(CharSequence text, DateTimeFormatter formatter)
        // 使用特定格式化程序从文本字符串中获取LocalDateTime的实例。
        return LocalDateTime.parse( strDate, DTF );
    }

    /**
     * description: date -> LocalDateTime
     *
     * @param date 日期
     * @return java.util.Date
     */
    public static LocalDateTime DateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone( zoneId ).toLocalDateTime();
    }

    /**
     * description:localDateTime -> date
     *
     * @param localDateTime 线程安全日期
     * @return java.util.Date
     */
    public static Date LocalDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone( zoneId );
        return Date.from( zonedDateTime.toInstant() );
    }

    public static void main(String[] args) throws ParseException {
        String date1 = DateUtil.formatDate( new Date() );
        System.out.println( date1 );

        //public static LocalDateTime now()：从默认时区中的系统时钟获取当前日期时间。
        String date2 = DateUtil.formatDate( LocalDateTime.now() );
        System.out.println( date2 );

        String s = "2022-10-23 11:22:30";
        Date date3 = DateUtil.parse( s );
        System.out.println( date3 );

        LocalDateTime date4 = DateUtil.parseTime( s );
        System.out.println( date4 );
        Date date5 = LocalDateTimeToDate( date4 );
        System.out.println( date5 );
        LocalDateTime date6 = DateToLocalDateTime( date5 );
        System.out.println( date6 );

    }
}
