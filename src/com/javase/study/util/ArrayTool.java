package com.javase.study.util;

import org.junit.Test;

import java.util.Random;

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
        return stringBuilderToString( sb );
    }

    /**
     * 产生4位随机字符串
     */
    public String getCheckCode() {
        String base = "QAZXSWEDCVFRTGBNHYUJMKIOLPqazxswedcvfrtgbnhyujmkiolp0123456789";
        int size = base.length();
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 4; i++) {
            //产生0到size-1的随机值
            int index = r.nextInt( size );
            //返回base字符串中指定索引处的 char值
            char c = base.charAt( index );
            //将c放入到StringBuffer中去
            sb.append( c );
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String a = "acdf";
        String code = getCheckCode();
        boolean b = code.equalsIgnoreCase( a );
        System.out.println( b );
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
