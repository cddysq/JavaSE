package com.javase.study;


import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class Clutter {

    public static void main(String[] args) {
        System.out.println( "hello word !!!" );
        char a = 'a';
        char A = 'A';
        char lin = '0';
        System.out.println( a + 0 );
        System.out.println( A + 0 );
        System.out.println( lin + 0 );

        System.out.println( "============================" );
        int result[] = calculate( 10, 20, 30 );
        System.out.println( "main方法接收的地址值=" + result );
        System.out.println( "总和：" + result[0] );
        System.out.println( "平均数：" + result[1] );

        System.out.println( "==========位置查找===========" );
        int[] arr = {20, 100, 111, 520, 52};
        Scanner sc = new Scanner( System.in );
        System.out.println( "请输入要查找的数据：" );
        int number = sc.nextInt();
        int index = findIndex( arr, number );
        System.out.println( "元素在数组中的索引=" + index );

        System.out.println( "==========评委打分===========" );
        int[] array = new int[6];
        for (int i = 0; i < array.length; i++) {
            System.out.println( "第" + (i + 1) + "个评委开始打分：" );
            array[i] = sc.nextInt();
        }
        int max = getMax( array );
        int min = getMin( array );
        int sum = getSum( array );
        int avg = (sum - max - min) / (array.length - 1);
        System.out.println( "选手的最终成绩为：" + avg );

        System.out.println( "==========排序===========" );
        Scanner scanner = new Scanner( System.in );
        System.out.println( "请输入第一个整数：" );
        int x = scanner.nextInt();
        System.out.println( "请输入第二个整数：" );
        int y = scanner.nextInt();
        System.out.println( "请输入第三个整数：" );
        int z = scanner.nextInt();
        t( x, y, z );

    }

    public static int[] calculate(int a, int b, int c) {
        //  求和
        int sum = a + b;
        //求平均数
        int avg = sum / 3;
        int[] array = {sum, avg};
        System.out.println( array );
        System.out.println( "=============================" );
        return array;
    }


    /**
     * 数组反转案例
     */
    @Test
    public void reversal() {
        int[] arr = {12, 15, 80, 520, 1314, 0};
        reverse( arr );
        printArray( arr );
    }

    /**
     * 反转数组
     */
    public static void reverse(int[] arr) {
        for (int start = 0, end = arr.length - 1; start <= end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    /**
     * 查找指定元素在数组中的位置
     */
    public static int findIndex(int[] arr, int number) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 遍历数组
     */
    public static void printArray(int[] arr) {
        System.out.print( "[" );
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print( arr[i] );
            } else {
                System.out.print( arr[i] + "," );
            }
        }
        System.out.println( "]" );
    }

    /**
     * 返回数组最大值
     */
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * 返回数组最小值
     */
    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * 返回数组总和
     */
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * 百钱百鸡：鸡翁一只钱五，鸡母一只钱三，鸡雏三只钱一，问鸡翁、鸡母、鸡雏各几何？
     */
    @Test
    public void buyChicken() {
        //鸡翁数量范围
        for (int x = 0; x <= 20; x++) {
            //鸡母数量范围
            for (int y = 0; y <= 33; y++) {
                //鸡雏数量
                int z = 100 - x - y;
                //总条件
                if (z % 3 == 0 && (5 * x + 3 * y + z / 3 == 100)) {
                    System.out.println( "鸡翁=" + x + ",鸡母=" + y + ",鸡雏=" + z );
                }
            }
        }
    }

    @Test
    public void table() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print( j + "*" + i + "=" + i * j + "\t" );
            }
            System.out.println();
        }
    }

    public static void t(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort( arr );
        String s = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            s += arr[i] + " ";
        }
        System.out.println( "从大到小的顺序是：" + s );
    }
}