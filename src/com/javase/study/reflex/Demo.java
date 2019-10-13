package com.javase.study.reflex;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author：Haotian
 * @Date：2019/10/13 11:03
 */
public class Demo {
    private static Class<?> c;
    private static Object obj;

    static {
        try {
            //通过反射路径找到字节码文件
            c = Class.forName( "com.javase.study.reflex.Student" );
            //getConstructor返回构造函数
            Constructor<?> constructor = c.getConstructor();
            //newInstance用此构造函数对象表示的构造函数创建并初始化具有指定初始化参数的构造函数声明类的新实例。
            obj = constructor.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //getConstructor获取构造方法
        Constructor<?> constructor = c.getConstructor( String.class, int.class, String.class );
        //newInstance创建对象传入参数
        Object o = constructor.newInstance( "艾莉丝", 18, "克罗地亚" );
        System.out.println( o );
    }

    @Test
    public void privateAccess() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //getDeclaredConstructor获取私有构造方法
        Constructor<?> constructor = c.getDeclaredConstructor( String.class, int.class, String.class );
        //setAccessible(true)反射的对象在使用时应该禁止对Java语言访问控制的检查
        constructor.setAccessible( true );
        Object s = constructor.newInstance( "艾莉丝", 18, "克罗地亚" );
        System.out.println( s );
    }

    @Test
    public void demo() throws Exception {
        //getDeclaredFields返回由这个类对象表示的类或接口声明的所有字段
        Field[] files = c.getDeclaredFields();
        files[0].setAccessible( true );
        files[0].set( obj, "椎名真白" );
        files[1].setAccessible( true );
        files[1].set( obj, 18 );
        files[2].setAccessible( true );
        files[2].set( obj, "日本" );
        System.out.println( obj );
    }

    @Test
    public void demo2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m1 = c.getDeclaredMethod( "method1" );
        Method m2 = c.getDeclaredMethod( "method2" );
        //invoke通过传入的对象执行对应的方法
        m1.invoke( obj );
        m2.setAccessible( true );
        m2.invoke( obj );
        Method m3 = c.getDeclaredMethod( "method3", String.class );
        m3.invoke( obj, "ok" );
        Method m4 = c.getMethod( "method4", String.class, int.class );
        Object o = m4.invoke( obj, "方法四", 1 );
        System.out.println( o );
    }

}
