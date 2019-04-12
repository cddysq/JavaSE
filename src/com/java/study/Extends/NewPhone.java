package com.java.study.Extends;

/**
 * 定义一个新手机，使用老手机作为父类
 * 当原本类已经在使用时，推荐进行方法重写，不对原本类进行改变。
 * super：子类访问父类构造方法，必须写在第一行。
 */
public class NewPhone extends Phone {
    @Override
    public void show() {
        super.show(); //把父类的show方法拿过来重复利用
        System.out.println("显示姓名");
        System.out.println("显示头像");
    }
}
