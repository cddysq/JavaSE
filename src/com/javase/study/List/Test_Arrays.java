package com.javase.study.List;

import org.junit.Test;

import java.util.Arrays;

/**
 * public static String toString(数组)：将参数数组变成字符串。
 * public static void sort(数组)：按照默认升序（从小到大）对数组的元素进行排序。
 */
public class Test_Arrays {
    public static void main(String[] args) {
        int[] intArray = {10, 20, 30};
        //将int[]数组按照默认格式变成字符串
        String intstr = Arrays.toString( intArray );
        System.out.println( intstr );

        int[] array1 = {18, 3, 6, 20, 1};
        String[] array2 = {"A", "Z", "J", "D", "b"};
        Arrays.sort( array1 );
        Arrays.sort( array2 );
        System.out.println( Arrays.toString( array1 ) );
        System.out.println( Arrays.toString( array2 ) );
    }

    /**
     * 不死神兔，第一个月一对兔子，第二个月一对兔子，从第三个月开始老兔子每月会生一对兔子，到第20个月总共有多少兔子
     * 例：一月1对，二月1对，三月2对，四月3对，五月5对
     */
    @Test
    public void test() {
        //定义一个长度为20的数组，存储每个月的兔子个数
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            //arr[2]=arr[2]+arr[1]
            //arr[3]=arr[1]+arr[2]
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        System.out.println( "第二十个月兔子的对数为=" + arr[19] );
    }
}
