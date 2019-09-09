package com.javase.study.String;

import java.util.Scanner;

/**
 * 键盘输入一个字符串，并统计其中各种字符出现的次数
 * 种类有:大写字母、小写字母、数字、其他
 */
public class Case_String2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );
        System.out.println( "请输入一个字符串：" );
        //获取键盘输入数字
        String input = sc.nextLine();
        //大写字母次数
        int countUpper = 0;
        //小写字母次数
        int countLower = 0;
        //数字次数
        int countNumber = 0;
        //其他字符次数
        int countOther = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt( i );
            if ('A' <= c && c <= 'Z') {
                countUpper++;
            } else if ('a' <= c && c <= 'z') {
                countLower++;
            } else if ('0' <= c && c <= '9') {
                countNumber++;
            } else {
                countOther++;
            }
        }
        System.out.println( "大写字母出现次数为：" + countUpper );
        System.out.println( "小写字母出现次数为：" + countLower );
        System.out.println( "数字出现次数为：" + countNumber );
        System.out.println( "其他字符出现次数为：" + countOther );
    }
}
