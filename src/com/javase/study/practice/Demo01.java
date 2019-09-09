package com.javase.study.practice;

import com.javase.study.Clutter;
import com.javase.study.Interface.Main;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author：Haotian
 * @Date：2019/9/6 10:21
 */
public class Demo01 {

    private static Scanner s = new Scanner( System.in );
    private Random r = new Random();

    private static int getMax(int a, int b, int c) {
        int temp = a > b ? a : b;
        int max = temp > c ? temp : c;
        return max;
    }

    public static void main(String[] args) {
        //jo();
        //reward();
        month();
    }

    /**
     * 利用三元运算符比较10,20,30 这三个数的大小
     */
    @Test
    public void getMax01() {
        int a = 10;
        int b = 20;
        int c = 30;
        int max = getMax( a, b, c );
        System.out.println( max );
    }

    /**
     * 生成三个随机数比较，求出最大值
     */
    @Test
    public void getMax02() {
        int x = r.nextInt( 10 );
        int y = r.nextInt( 10 );
        int z = r.nextInt( 10 );
        System.out.println( getMax( x, y, z ) );
    }

    /**
     * 键盘录入一个数，判断基偶，并输出
     */
    public static void jo() {
        System.out.println( "请输入一个数字判断奇偶：" );
        int number = s.nextInt();
        if ((number & 1) == 1) {
            System.out.println( "此数字为奇数" );
        } else {
            System.out.println( "此数字为偶数" );
        }
    }

    /**
     * if进行奖励判断
     */
    public static void reward() {
        System.out.println( "请输入孩子的成绩：" );
        int number = s.nextInt();
        if (number < 0 || number > 100) {
            System.out.println( "数据错误" );
        } else if (number >= 95 && number <= 100) {
            System.out.println( "山地自行车" );
        } else if (number >= 90 && number <= 94) {
            System.out.println( "游乐园游玩" );
        } else if (number >= 85 && number <= 89) {
            System.out.println( "奖励变形金刚" );
        } else {
            System.out.println( "暴揍一顿" );
        }
    }

    /**
     * switch求季节
     */
    public static void month() {
        System.out.println( "请输入一个月份进行季节查询：" );
        int yue = s.nextInt();
        switch (yue) {
            case 2:
            case 3:
            case 4:
                System.out.println( "春季" );
                break;
            case 5:
            case 6:
            case 7:
                System.out.println( "夏季" );
                break;
            case 8:
            case 9:
            case 10:
                System.out.println( "秋季" );
                break;
            case 11:
            case 12:
            case 1:
                System.out.println( "冬季" );
                break;
            default:
                System.out.println( "您输入的月份有误" );
        }
    }

    /**
     * 求1-100之间的偶数和，并输出偶数之和
     */
    @Test
    public void sum01() {
        int sum = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println( "1-100偶数之和=" + sum );
    }

    /**
     * 求出1000以内的水仙花数有多少个（水仙花目前特指三位数）
     */
    @Test
    public void count01() {
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100 % 10;
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i) {
                count++;
            }
        }
        System.out.println( "水仙花个数=" + count );
    }

    /**
     * 求学生最高成绩和最低成绩之和
     */
    @Test
    public void sum02() {
        int[] arr = {11, 22, 33, 44, 55, 66, 77, 88, 99, 100};
        int max = Clutter.getMax( arr );
        int min = Clutter.getMin( arr );
        System.out.println( "sum=" + (max + min) );
    }

    /**
     * 随机生成10个1-10之间的数，赋值给一个长度为10的int类型数组，并求出10个数之和
     */
    @Test
    public void sum03() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt( 10 ) + 1;
        }
        System.out.println( "随机数总和为=" + Clutter.getSum( arr ) );
    }

    /**
     * 统计高于平均分的分数有多少个
     */
    @Test
    public void count02(){
        int[] arr = {95, 92, 75, 56, 98, 71, 80, 58, 91, 91};

    }

    /**
     * 求数组平均数
     * @param arr
     */
    public static int avg(int[] arr){
        int avg = 0;

        return avg;
    }
}
