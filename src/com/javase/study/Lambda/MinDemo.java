package com.javase.study.Lambda;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @Author: Haotian
 * @Date: 2020/1/30 11:55
 * @Description: 命令式编程与函数式编程求最小值
 */
public class MinDemo {

    @Test
    public void is() {
        int[] numbers = {12, 36, -10, 68, -2, 0};
        //命令式编程方式
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (min > number) {
                min = number;
            }
        }
        System.out.println( min );
        //lambda
        IntStream.of( numbers ).parallel().min().stream().forEach( System.out::println );
    }
}