package com.javase.study.reflex;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：Haotian
 * @Date：2019/10/13 11:02
 */
@Data

@NoArgsConstructor
public class Student {
    private String name;
    private int age;
    private String address;

    private Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void study() {
        System.out.println( "开始学习了" );
    }

    public void method1() {
        System.out.println( "公有方法一" );
    }

    private void method2() {
        System.out.println( "私有方法二" );
    }

    public void method3(String s) {
        System.out.println( "公有方法三" + s );
    }

    public String method4(String s, int r) {
        return s + r;
    }
}
