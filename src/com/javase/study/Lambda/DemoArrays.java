package com.javase.study.Lambda;

import java.util.Arrays;

/**
 * Lambda表达式有参数返回值的练习
 * 需求：
 * 使用数组储存多个person对象
 * 将年龄进行升序排序
 */
public class DemoArrays {
    public static void main(String[] args) {
        Person[] arr = {
                new Person( "艾米莉亚", 20 ),
                new Person( "夏娜", 24 ),
                new Person( "蕾姆", 18 )
        };
        //普通实现方式
        /*Arrays.sort( arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        } );*/

        //使用Lambda表达式，简化
        Arrays.sort( arr, (o1, o2) -> o1.getAge() - o2.getAge() );
        //遍历数组
        for (Person p : arr) {
            System.out.println( p );
        }
    }
}
