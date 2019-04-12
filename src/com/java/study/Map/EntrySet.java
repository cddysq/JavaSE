package com.java.study.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * EntrySet遍历Map集合
 * Set<Map.Entry<K,V>> entrySet() 返回此映射中包含的映射关系的Set视图
 */
public class EntrySet {
    public static void main(String[] args) {
        //1.使用Map集合中的entrySet()，把集合中多个Entry对象取出来，存储到一个Set集合中
        Map<Integer, String> map = new HashMap<>();
        //put添加
        map.put( 20, "貂蝉" );
        map.put( 22, "吕布" );
        map.put( 19, "杨玉环" );
        map.put( 18, "妲己" );
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        //2.遍历Set集合，获取集合中的每一个Entry对象
        Iterator<Map.Entry<Integer, String>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            //3.使用Entry对象中的方法getKey()和getValue()获取键与值
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println( key + "," + value );
        }
        System.out.println( "=============================" );

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println( key + "=" + value );
        }

    }
}
