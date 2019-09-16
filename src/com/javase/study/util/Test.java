package com.javase.study.util;

import java.util.Random;

/**
 * @Author：Haotian
 * @Date：2019/9/12 14:37
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Random r = new Random();
        //求java指定区间的随机数
        //rand.nextInt(最大值-最小值+1)+最小值
        for (int i = 0; i < 5; i++) {
            arr[i] = r.nextInt( 100 - 2 + 1 ) + 2;
        }
        System.out.println( "随机生成的数组为：\n" + arrayToString( arr ) );
        int[] newArr = getNewArr( arr );
        System.out.println( "调用getNewArr方法后的数组为：\n" + arrayToString( newArr ) );
    }

    /**
     * 偶数替换
     *
     * @param arr
     * @return
     */
    public static int[] getNewArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] = 0;
            }
        }
        return arr;
    }

    /**
     * 字符串拼接
     *
     * @param arr 数组
     * @return 遍历后的数组
     */
    public static String arrayToString(int[] arr) {
        if (arr == null) {
            return null;
        }
        //StringBuilder在单线程下速度更快
        StringBuilder sb = new StringBuilder();
        sb.append( "[" );
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append( arr[i] );
            } else {
                sb.append( arr[i] ).append( ", " );
            }
        }
        sb.append( "]" );
        return sb.toString();
    }
}
