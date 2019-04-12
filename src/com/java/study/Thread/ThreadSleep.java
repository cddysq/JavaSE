package com.java.study.Thread;

/**
 * public static void sleep(long millis):使用当前正在执行的线程以指定的毫秒暂停（暂时停止执行），毫秒结束后，线程继续执行
 */
public class ThreadSleep {
    public static void main(String[] args) {
        for (int i = 0; i < 60; i++) {
            System.out.println(i);

            //使用Thread类的sleep方法，让程序睡眠一秒
            try {
                Thread.sleep( 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
