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
            //随机数取值范围1-5
            //(最大-最小+1)+最小30-50
            int result = r.nextInt( n ) + 1;
            System.out.println( "随机数是：" + result );
        }
    }
}
