package com.javase.study.practice;

import java.security.Key;
import java.util.*;

/**
 * @Author：Haotian
 * @Date：2019/9/26 18:14
 */
public class Day03 {
    public static void main(String[] args) {
        stringToMap();
        charCount();

        HashMap<Integer, String> map = new HashMap<>();
        map.put( 1930, "乌拉圭" );
        map.put( 1934, "意大利" );
        map.put( 1938, "意大利" );
        map.put( 1950, "乌拉圭" );
        map.put( 1954, "西德" );
        map.put( 1958, "巴西" );
        map.put( 1962, "巴西" );
        map.put( 1966, "英格兰" );
        map.put( 1970, "巴西" );
        map.put( 1974, "西德" );
        map.put( 1978, "阿根廷" );
        map.put( 1982, "意大利" );
        map.put( 1986, "阿根廷" );
        map.put( 1994, "巴西" );
        map.put( 1998, "法国" );
        map.put( 2002, "巴西" );
        map.put( 2006, "意大利" );
        map.put( 2010, "西班牙" );
        map.put( 2014, "德国" );
        Scanner scanner = new Scanner( System.in );
        System.out.println( "请输入一个年份：" );
        int year = scanner.nextInt();
        if (map.containsKey( year )) {
            System.out.println( year + "年，获得世界杯冠军的队伍是：" + map.get( year ) );
        } else {
            System.out.println( "该年没有举办世界杯" );
        }
        System.out.println( "请输入一个国家名称：" );
        String country = scanner.next();
        if (map.containsValue( country )) {
            for (Integer k : map.keySet()) {
                if (map.get( k ).equals( country )) {
                    System.out.println( k + "\n" );
                }
            }
        } else {
            System.out.println( "该国家没有获得过世界杯冠军" );
        }
    }

    private static void charCount() {
        List<String> list = new ArrayList<>();
        list.add( "abc" );
        list.add( "bcd" );
        HashMap<Character, Integer> map = new HashMap<>();
        for (String s : list) {
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (map.containsKey( c )) {
                    int value = map.get( c );
                    value++;
                    map.put( c, value );
                } else {
                    map.put( c, 1 );
                }
            }
        }
        System.out.println( map );
    }

    private static void stringToMap() {
        String[] arr1 = {"黑龙江省", "浙江省", "江西省", "广东省", "福建省"};
        String[] arr2 = {"哈尔滨", "杭州", "南昌", "广州", "福州"};
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            String key = arr1[i];
            String value = arr2[i];
            map.put( key, value );
        }
        System.out.println( map );
    }
}
