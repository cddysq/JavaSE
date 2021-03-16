package com.javase.study.Thread;

/**
 * 逃逸分析：逃逸分析并不是直接的优化手段，而是一个代码分析，通过动态分析对象的作用域，为其它优化手段如栈上分配、标量替换和同步消除等
 * 方法逃逸：当一个对象在方法中定义之后，作为参数传递到其它方法中
 * 线程逃逸：如类变量或实例变量，可能被其它线程访问到
 *
 * @author Haotian
 * @version 1.0
 * @date 2021/3/16 21:15
 */
public class StackAllocTest {
    /**
     * 进行两种测试
     * 关闭逃逸分析，同时调大堆空间，避免堆内GC的发生，如果有GC信息将会被打印出来
     * VM运行参数：-Xmx4G -Xms4G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
     * <p>
     * 开启逃逸分析
     * VM运行参数：-Xmx4G -Xms4G -XX:+DoEscapeAnalysis -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
     * <p>
     * 执行main方法后
     * jps 查看进程
     * jmap -histo 进程ID
     */

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        // 查看执行时间
        System.out.println( "cost-time " + (end - start) + " ms" );
        try {
            Thread.sleep( 100000 );
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }


    private static void alloc() {
        // Jit对编译时会对代码进行 逃逸分析
        Person person = new Person();
    }

    static class Person {
        private String name;
        private int age;
    }
}
