package com.java.study.List;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 将一个随机字符串中的所有字符升序排列，并倒序打印。
 */
public class Case_Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要进行排序的字符数据：");
        String input = sc.next();
        //String --> 数组，用toCharArray
        char[] chars = input.toCharArray();
        Arrays.sort(chars);//进行排序

        //倒序遍历数组、
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println(chars[i]);
        }
    }
}
