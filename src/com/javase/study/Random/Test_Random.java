package com.javase.study.Random;

import java.util.Random;

/**
 * Random类用来生成随数字。
 */
public class Test_Random {
    public static void main(String[] args) {
        int n = 5;
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            int result = r.nextInt(n) + 1;//随机数取值范围1-5
            System.out.println("随机数是：" + result);
        }
    }
}
