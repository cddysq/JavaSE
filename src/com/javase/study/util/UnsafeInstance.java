package com.javase.study.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Haotian
 * @version 1.0
 * @date 2021/3/15 20:20
 */
public class UnsafeInstance {
    public static Unsafe reflectGetUnsafe() {
        try {
            // 通过反射获取不安全的魔术类
            Field field = Unsafe.class.getDeclaredField( "theUnsafe" );
            field.setAccessible( true );
            return (Unsafe) field.get( null );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
