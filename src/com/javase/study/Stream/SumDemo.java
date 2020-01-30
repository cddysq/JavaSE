package com.javase.study.Stream;

import java.util.stream.IntStream;

/**
 * @Author: Haotian
 * @Date: 2020/1/30 14:01
 * @Description: 普通求和操作与Stream流
 */
public class SumDemo {
    public static void main(String[] args) {
        //外部迭代
        int[] numbers = {-1, 0, 98, -20, 1, 22};
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println( "总合为：" + sum );
        //Stream内部迭代方式
        //map是中间操作(也就是返回stream的操作)
        //sum是终止操作
        int sum2 = IntStream.of( numbers ).map( SumDemo::doubleNumber ).sum();
        System.out.println( "总合为：" + sum2 );

        System.out.println( "惰性求值就是未进行终止的情况下，中间操作不会执行" );
        IntStream.of( numbers ).map( SumDemo::doubleNumber );
    }

    public static int doubleNumber(int number) {
        System.out.println( "执行了乘以2操作" );
        return number * 2;
    }
}