package com.javase.study.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map<k,v>集合
 * Map集合的特点：
 * 1.Map集合是一个双列集合，一个元素包含两个值（一个key,一个value）
 * 2.Map集合中的元素，key和value的数据类型可以相同，也可以不同
 * 3.Map集合中的元素，key是不允许重复的，value是可以重复的
 * 注意：如果使用自定义类对象作为key时，必须重写hashCode和equals方法，保证唯一性
 * 4.Map集合中的元素，key和value是一一对应的
 * <p>
 * java.util.HashMap<k,v>集合 implements Map<k,v>接口
 * HashMap集合特点：
 * 1.HashMap集合底层是哈希表：查询速度非常快
 * 2.HashMap集合是一个无序的的集合，储存元素和取出元素的顺序有可能不一致
 * <p>
 * java.util.LinkedHashMap<k,v>集合 extends HashMap<k,v>接口
 * LinkedHashMap的特点：
 * 1.LinkedHashMap集合底层是哈希表+链表
 * 2.LinkedHashMap集合是一个有序的集合，储存元素和取出元素的顺序是一致的
 */
public class Test_Map {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //put添加
        map.put( "貂蝉", 18 );
        map.put( "吕布", 20 );
        map.put( "杨玉环", 19 );
        map.put( "妲己", 22 );
        map.put( "妲己", 23 );
        System.out.println( map );

        //删除remove，key删除，返回value
        Integer remove = map.remove( "妲己" );
        System.out.println( remove );

        //get,根据key,获取对应的值
        Integer get = map.get( "貂蝉" );
        System.out.println( get );

        //containsKey,根据key查找元素是否存在
        boolean b = map.containsKey( "吕布" );
        System.out.println( b );
    }
}
