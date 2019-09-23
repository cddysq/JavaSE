package com.javase.study.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author：Haotian
 * @Date：2019/9/23 10:26
 */
public class GenericDemo {
    /**
     * 类型通配符：<?>
     * List<?>表示元素类型未知的List，他的元素可以匹配任意类型
     * 类型通配符上限：<? extends 类型>
     * List<? extends Number>表示元素的匹配类型最高只能是Number
     * 类型通配符下限：<? super 类型>
     * List<? super Number>表示元素的匹配类型最低只能是Number
     */
    List<?> list1 = new ArrayList<Object>();
    List<?> list2 = new ArrayList<Number>();
    List<?> list3 = new ArrayList<Integer>();

    /*List<? extends Number> list4 = new ArrayList<Object>();*/

    List<? extends Number> list5 = new ArrayList<Number>();
    List<? extends Number> list6 = new ArrayList<Integer>();

    List<? super Number> list7 = new ArrayList<Object>();
    List<? super Number> list8 = new ArrayList<Number>();

    //List<? super Number> list9 = new ArrayList<Integer>();

    /**
     * 泛型方法格式：修饰符<类型> 返回值类型 方法名(类型 变量名){}
     * T... a：可变参数只能放在最后，不限制数据个数用于接收所有传入数据
     */
    public static <T> void demo(T... a) {
        Stream.of( a ).forEach( System.out::println );
    }

    public static void main(String[] args) {
        demo( "string" );
        demo( 10, 20, 30 );
    }
}
