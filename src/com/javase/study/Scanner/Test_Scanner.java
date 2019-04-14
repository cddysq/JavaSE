package com.javase.study.Scanner;

import java.util.Scanner;

/**
 * Scanner类的功能：可以实现键盘输入数据到程序中
 */
public class Test_Scanner {
    public static void main(String[] args) {

        //System.in代表从键盘进行输入
        Scanner sc = new Scanner(System.in);

        //获取键盘输入的int数字
        System.out.println("请输入一个int数据：");
        int num = sc.nextInt();
        System.out.println("输入的int数字是：" + num);

        //获取键盘输入的字符串
        System.out.println("请输入一个String数据：");
        String str = sc.next();
        System.out.println("输入的字符串是：" + str);

        System.out.println("总和为=" + (num + str));
    }
}
