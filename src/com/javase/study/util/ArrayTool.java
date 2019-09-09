package com.javase.study.util;

/**
 * @Author：Haotian
 * @Date：2019/9/7 15:21
 */
public class ArrayTool {
    /**
     * 字符串拼接
     *
     * @param arr 数组
     * @return 遍历后的数组
     */
    public String arrayToString(int[] arr) {
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
        return stringBuilderToString( sb );
    }

    /**
     * 字符串反转
     *
     * @param s 字符串
     * @return
     */
    public String reverse(String s) {
        return new StringBuilder( s ).reverse().toString();
    }

    /**
     * 类型转换StringBuilder -> String
     */
    private String stringBuilderToString(StringBuilder sb) {
        return sb.toString();
    }
}
