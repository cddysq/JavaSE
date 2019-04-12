package com.java.study.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * KeySet遍历Map集合，通过键找值的方式
 * Set<K> keySet() 返回此映射中包含的键的Set视图
 */
public class KeySet {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        //put添加
        map.put( 20, "貂蝉" );
        map.put( 22, "吕布" );
        map.put( 19, "杨玉环" );
        map.put( 18, "妲己" );

        //1.使用Map集合中的KeySet()，把集合所有的key取出来，存储到一个Set集合中
        Set<Integer> set = map.keySet();

        //2.遍历Set集合，获取集合中的每一个key
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            //3.通过Map集合中的get(Key)，找到对应的value
            String value = map.get( key );
            System.out.println( key + "," + value );
        }

        System.out.println( "==============================" );
        for (Integer key : map.keySet()) {
            String value = map.get( key );
            System.out.println( key + "=" + value );

        }
    }
}
