package com.java.study.Map;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 计算一个字符串中每个字符的出现次数
 */
public class Case_Map {
    public static void main(String[] args) {
        //1.使用Scanner获取用户输入的字符
        Scanner sc = new Scanner( System.in );
        System.out.println( "请输入一组字符串：" );
        String input = sc.next();
        //2.创建Map集合，key是字符中的字符，value是字符的个数
        HashMap<Character, Integer> map = new HashMap<>();
        //3.遍历字符串，获取每一个字符
        for (char c : input.toCharArray()) {
            //4.使用获取到的字符串，去Map集合判断key是否存在
            if (map.containsKey( c )) {
                //key存在
                Integer value = map.get( c );
                value++;
                map.put( c, value );
            } else {
                //key不存在
                map.put( c, 1 );
            }
        }
        //5.遍历Map集合，输出结果
        for (Character key : map.keySet()) {
            Integer value = map.get( key );
            System.out.println( key + "=" + value );
        }


    }
}
