package com.javase.study.Interface;

/**
 * 接口就是多个类的公共规范。
 * 接口是一种引用数据类型，最重要的内容就是其中的：抽象方法。
 * <p>
 * 如果是Java7,那么接口中可以包含的内容有：
 * 1.常量:必须使用public static final三个关键字进行修饰。
 * 2.抽象方法
 * <p>
 * 如果是Java8,额外包含:
 * 4.默认方法
 * 5.静态方法
 * <p>
 * 如果是Java9,额外包含：
 * 5.私有方法：解决默认方法之间的重复代码。
 * <p>
 * 接口使用步骤：
 * 1.接口不能直接使用，必须有一个“实现类”来“实现”接口
 * 格式：public class 实现类名称 implements 接口名称{
 * //....
 * }
 * 2.接口的实现类必须覆盖重写（实现）接口中所有的抽象方法。
 * 3.创建实现类对象，进行使用。
 * <p>
 * 注意事项：
 * 如果实现类并没有覆盖重写接口中所有的抽象方法，那么这个实现类自己就必须是抽象类。
 */
public interface MyInterface {

    //定义一个常量，一旦赋值，不可以修改
    public static final int NUM = 10;

    //接口中的关键字可以省略不写
    public abstract void method();

    public void method2();

    abstract void method3();

    void method4();

    //添加新的方法，改成默认方法，解决接口升级的问题
    public default void methodDefault() {
        System.out.println("这是新添加的默认方法");
    }

    //添加静态方法
    public static void methodStaticA() {
        System.out.println("静态方法A");
        methodStatic();
    }

    public static void methodStaticB() {
        System.out.println("静态方法B");
        methodStatic();
    }

    private static void methodStatic() {
        System.out.println("这是接口的静态方法！");
        System.out.println("私有解决重复代码");
    }

}
