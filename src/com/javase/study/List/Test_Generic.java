package com.javase.study.List;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 当传输的数据不确定时，使用泛型
 * 泛型可以使用通配符“？”，表示什么数据类型都能接收
 * 泛型的上限限定：？ extend E 代表使用泛型只能是E类型的子类/本身
 * 泛型的下限限定：？ super E 代表使用泛型只能是E类型的父类/本身
 */
public class Test_Generic {
    public static void main(String[] args) {
        Collection<Integer> list1 = new ArrayList<>();
        Collection<String> list2 = new ArrayList<>();
        Collection<Number> list3 = new ArrayList<>();
        Collection<Object> list4 = new ArrayList<>();
        /**
         * Integer extends Number extends Object
         * String extends Object
         */
        getElement1( list1 );
        //getElement1( list2 );报错
        getElement1( list3 );
        //getElement1( list4 );报错

        //getElement2( list1 );报错
        //getElement2( list2 );报错
        getElement2( list3 );
        getElement2( list4 );

    }

    public static void getElement1(Collection<? extends Number> collection) {

    }

    public static void getElement2(Collection<? super Number> collection) {

    }
}
