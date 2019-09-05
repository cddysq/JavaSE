package com.javase.study.Scanner;

import org.junit.Test;

import java.util.Scanner;

/**
 * Scanner类的功能：可以实现键盘输入数据到程序中
 */
public class Test_Scanner {
    @Test
    public void sum() {
        //System.in代表从键盘进行输入
        Scanner sc = new Scanner( System.in );

        //获取键盘输入的int数字
        System.out.println( "请输入一个int数据：" );
        int num = sc.nextInt();
        System.out.println( "输入的int数字是：" + num );

        //获取键盘输入的字符串
        System.out.println( "请输入一个String数据：" );
        String str = sc.next();
        System.out.println( "输入的字符串是：" + str );

        System.out.println( "总和为=" + (num + str) );
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        System.out.println( "请输入一个月份：" );
        int month = sc.nextInt();
        //case穿透1
        switch (month) {
            case 2:
            case 3:
            case 4:
                System.out.println( "春季" );
                break;
            case 5:
            case 6:
            case 7:
                System.out.println( "夏季" );
                break;
            case 8:
            case 9:
            case 10:
                System.out.println( "秋季" );
                break;
            case 11:
            case 12:
            case 1:
                System.out.println( "冬季" );
                break;
            default:
                System.out.println( "您输入的月份有误" );
        }
    }

    /**
     * 水仙花数
     * 每位数的立方相加等于原数371=3*3*3+7*7*7+1*1*1
     */
    @Test
    public void daffodil() {
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 10 / 10 % 10;
            if ((ge * ge * ge) + (shi * shi * shi) + (bai * bai * bai) == i) {
                System.out.println( i );
                count++;
            }
            System.out.println( "水仙花一共有" + count + "个" );
        }
    }

}
