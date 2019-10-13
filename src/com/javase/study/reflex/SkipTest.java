package com.javase.study.reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Author：Haotian
 * @Date：2019/10/13 15:14
 */
public class SkipTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        //使用反射跳过集合泛型检查
        ArrayList<Integer> list = new ArrayList<>();
        //获取字节码文件
        Class<? extends ArrayList> listClass = list.getClass();
        //获取需要使用的方法，设置参数为任意类型
        Method add = listClass.getMethod( "add", Object.class );
        add.invoke( list, "一号" );
        add.invoke( list, "二号" );
        add.invoke( list, "三号" );
        System.out.println( list );
    }
}
