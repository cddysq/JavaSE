package com.javase.study.InnerClass;

/**
 * 内部类的使用
 * <p>
 * 匿名内部类定义格式：
 * 接口名称 对象名 = new 接口名称(){
 * //覆盖重写所有抽象方法
 * };
 * 注意：只能使用一次，再次使用需要再次创建
 */
public class Test_InnerClass {
    public static void main(String[] args) {

        //匿名内部类
        MyInterface obj = new MyInterface() {
            @Override
            public void method() {
                System.out.println( "匿名内部类实现接口" );
            }
        };
        obj.method();

    }
}
