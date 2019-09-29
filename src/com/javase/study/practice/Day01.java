package com.javase.study.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @Author：Haotian
 * @Date：2019/9/24 18:13
 */
public class Day01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add( "a" );
        list.add( "a" );
        list.add( "b" );
        list.add( "b" );
        list.add( "c" );
        System.out.println( "a:" + listTest( list, "a" ) );
        System.out.println( "b:" + listTest( list, "b" ) );
        System.out.println( "c:" + listTest( list, "c" ) );
        System.out.println( "xxx:" + listTest( list, "xxx" ) );
        System.out.println( "================================" );

        int[] arr = {1, 2, 3, 5, 8, 4};
        ArrayList<Integer> arrayList = intToInteger( arr );
        System.out.println( arrayList );
        System.out.println( "================================" );

        //集合转数组
        listToArray( arrayList );
        System.out.println( "================================" );

        //contains查找数据是否存在
        System.out.println( listP01( list, "a" ) );
        System.out.println( "================================" );

        //isEmpty判断是否为空
        System.out.println( listP02( list ) );
        System.out.println( "================================" );

        System.out.println( findFirstIndex( list, "c" ) );
        System.out.println( "================================" );

        ArrayList<Student> students = new ArrayList<>();
        students.add( new Student( "艾莉丝", 20, "女" ) );
        students.add( new Student( "艾米莉亚", 19, "女" ) );
        students.add( new Student( "蕾姆", 18, "女" ) );
        students.forEach( System.out::println );
        findMaxAge( students );
        System.out.println( "================================" );

        Random random = new Random();
        int[] arrs = new int[10];
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = random.nextInt( 100 ) + 1;
        }
        System.out.println( number( arrs ) );
    }

    /**
     * 过滤随机数
     *
     * @param arr 数据源
     * @return 大于20的数据
     */
    private static ArrayList<Integer> number(int[] arr) {
        ArrayList<Integer> number = new ArrayList<>();
        for (int i : arr) {
            if (i > 20) {
                number.add( i );
            }
        }
        return number;
    }

    /**
     * 查找最大年龄返回对应姓名
     *
     * @param students 学生集合
     */
    private static void findMaxAge(ArrayList<Student> students) {
        Integer maxAge = 0;
        Integer index = 0;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get( i );
            if (student.getAge() > maxAge) {
                maxAge = student.getAge();
                index = i;
            }
        }
        String name = students.get( index ).getName();
        students.get( index ).setName( "小猪佩奇" );
        String nameNow = students.get( index ).getName();
        System.out.println( "最大年龄为=" + maxAge + " 原名字：" + name + " 现名字：" + nameNow );
    }

    private static Integer findFirstIndex(ArrayList<String> list, String s) {
        //返回数据第一次出现索引，无返回-1
        for (int i = 0; i < list.size(); i++) {
            if (list.get( i ).equals( s )) {
                return i;
            }
        }
        return -1;
    }

    private static boolean listP01(ArrayList<String> al, String s) {
        if (al.contains( s )) {
            return true;
        }
        return false;
    }

    private static boolean listP02(ArrayList<String> al) {
        //判断al集合是否为空,为空返回true，不为空返回false
        if (al.isEmpty()) {
            return true;
        }
        return false;
    }

    private static void listToArray(ArrayList<Integer> arrayList) {
        Object[] array = arrayList.toArray();
        Stream.of( array ).forEach( System.out::println );
    }


    /**
     * 数组转集合
     *
     * @param number 带转换数组
     * @return 转化后的集合
     */
    private static ArrayList<Integer> intToInteger(int[] number) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : number) {
            arrayList.add( i );
        }
        return arrayList;
    }

    /**
     * 统计字符出现次数
     *
     * @param list 数据集合
     * @param xxx  待统计数据
     * @return 出现次数
     */
    private static Integer listTest(Collection<String> list, String xxx) {
        Integer count = 0;
        for (String s : list) {
            if (s.equals( xxx )) {
                count++;
            }
        }
        return count;
    }


}
