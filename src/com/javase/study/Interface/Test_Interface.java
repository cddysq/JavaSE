package com.javase.study.Interface;


public class Test_Interface {
    public static void main(String[] args) {
        //创建实现类的对象使用
        InterfaceImplA interA = new InterfaceImplA();
        interA.method();
        interA.method2();
        interA.methodDefault();//默认方法无需重写，可直接调用

        System.out.println("======================");
        InterfaceImplB interB = new InterfaceImplB();
        interB.method3();
        interB.method4();
        interB.methodDefault();//B类对默认方法进行了重写

        /**
         * 不能通过接口实现类的对象来调用接口当中的静态方法，需要直接使用接口名称进行调用。
         * 格式：接口名称.静态方法名(参数)
         */
        System.out.println("======================");
        MyInterface.methodStaticA();
        MyInterface.methodStaticB();

        //使用接口常量
        System.out.println("======================");
        System.out.println(MyInterface.NUM);

    }
}
