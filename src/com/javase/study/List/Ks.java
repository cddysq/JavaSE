package com.javase.study.List;

import org.junit.Test;

import java.util.Random;

/**
 * @Author：Haotan
 * @Date：2019/9/6 14:40
 */
public class Ks {
    private Random random = new Random();

    /**
     * 随机生成10个1-100之间的学生成绩，并统计高于学生成绩平均分的人有几个。
     */
    @Test
    public void countNum() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt( 100 ) + 1;
        }
        int count = 0;
        int avg = getAvg( arr );
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > avg) {
                count++;
            }
        }
        System.out.println( "高于平均成绩的人数为=" + count );
    }

    /**
     * 现有一个整数数组，数组中的每个元素都是[0-9]之间的数字，从数组的最大索引位置开始到最小索引位置，依次表示整数的个位、十位、百位。。。依次类推。请编写程序计算，这个数组所表示的整数值。
     */
    @Test
    public void pngJie() {
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt( 9 );
        }
        //int[] arr = {2, 1, 3, 5, 4};
        int number = 0;
        for (int i = 0; i < arr.length; i++) {
            //当前索引值*（10*最大索引值-当前索引）
            number += arr[i] * (Math.pow( 10, ((arr.length - 1) - i) ));
        }
        System.out.println( number );
    }

    /**
     * 中国有闰年的说法。闰年的规则是：四年一闰，百年不闰，四百年再闰。（年份能够被4整除但不能被100整除算是闰年，年份能被400整除也是闰年）。请打印出1988年到2019年的所有闰年年份。
     */
    @Test
    public void runNian() {
        for (int year = 1988; year <= 2019; year++) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                System.out.println( "满足条件的年份为：" + year );
            }
        }
    }

    /**
     * 比较int [] arr={1,2,3,4},  int [] arr2={2,3,4,5}这两个数组是否相同，用代码验证。
     */
    @Test
    public void panD() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {2, 3, 4, 5};
        boolean compare = compare( arr1, arr2 );
        if (compare == false) {
            System.out.println( "数组不相同" );
        } else {
            System.out.println( "数组相同" );
        }
    }

    /**
     * 逢七过：
     * 从任意一个数字开始报数，当你要报的数字包含7或者是7的倍数时都要说过
     * 要求：输出1-100之间需要跳过的数字
     */
    @Test
    public void game() {
        for (int i = 1; i < 100; i++) {
            if (i % 7 == 0 || i % 10 == 7 || i / 10 % 10 == 7) {
                System.out.println( "满足逢七过的数据为：" + i );
            }
        }
    }

    /**
     * 返回数组平均数
     */
    public int getAvg(int[] array) {
        int sum = getSum( array );
        int avg = sum / (array.length - 1);
        return avg;
    }

    /**
     * 返回数组总和
     */
    public int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * 返回数组是否相同
     */
    public boolean compare(int[] arr1, int[] arr2) {
        //比较长度
        if (arr1.length != arr2.length) {
            return false;
        }
        //比较数据
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
