package com.java.study.List;

import java.util.Arrays;

/**
 * public static String toString(数组)：将参数数组变成字符串。
 * public static void sort(数组)：按照默认升序（从小到大）对数组的元素进行排序。
 */
public class Test_Arrays {
    public static void main(String[] args) {
        int[] intArray = {10, 20, 30};
        //将int[]数组按照默认格式变成字符串
        String intstr = Arrays.toString(intArray);
        System.out.println(intstr);

        int[] array1 = {18, 3, 6, 20, 1};
        String[] array2 = {"A", "Z", "J", "D", "b"};
        Arrays.sort(array1);
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
}
