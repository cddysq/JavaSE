package com.javase.study.Final;

/**
 * final关键字代表最终的、不可改变的（不允许覆盖重写）。
 * 常见的四种用法：
 * 1.可以用来修饰一个类
 * 2.可以用来修饰一个方法
 * 3.可以用来修饰一个局部变量：不可改变的是地址值。
 * 4.可以用来修饰一个成员变量：需要手动赋值，不在产生默认值。
 */
public final class Test_Final {
    public static void main(String[] args) {
        final int num = 10;//不可改变，只能赋值一次
//        num = 20;
        System.out.println(num);

        final Person person = new Person( 18 );
        System.out.println("姓名"+person.getName()+",年龄"+person.getAge());
//        person person1 = new Person( 20 ); 地址值不可改变，内容可变
        person.setAge( 20 );
        System.out.println("新年龄"+person.getAge());
//        person.setName(  ); name被final修饰不可改变、


    }

}
