package com.java.study.InnerClass;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用接口传递参数
 * java.util.list正是ArrayList所实现的接口。
 */
public class DemoInterface {
    public static void main(String[] args) {
        //左边是接口名称，右边是实现类名称，这就是多态的写法
        List<String> list = new ArrayList<>();

        List<String> result = addName( list );
        for (int i = 0; i < result.size(); i++) {
            System.out.println( result.get( i ) );
        }
    }

    public static List<String> addName(List<String> list) {
        list.add( "瑶" );
        list.add( "云" );
        list.add( "海" );
        list.add( "碧" );
        return list;
    }
}
