package com.javase.study.System;

import java.util.Arrays;
import java.util.stream.Stream;

//System系统类
public class Test_System {
    public static void main(String[] args) {
        //demo1();
        demo2();

    }

    private static void demo1() {

        //currentTimeMillis返回当前时间
        long start = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            count++;
            System.out.println( "程序第" + count + "次执行" );
        }
        long end = System.currentTimeMillis();
        System.out.println( "程序最终耗时：" + (end - start) );
    }

    private static void demo2() {

        //将str数组的前三个元素，复制到dest数组的前三个位置上
        //arraycopy将数组中的指定数据拷贝到另一个数组中
        int[] src = {1, 2, 3, 4, 5, 6};
        int[] dest = {6, 7, 8, 9, 10};
        System.out.println( "复制前：" + Arrays.toString( dest ) );
        System.arraycopy( src, 1, dest, 0, 3 );
        System.out.println( "复制后：" + Arrays.toString( dest ) );
    }
}
