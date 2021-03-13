package com.javase.study.Thread;

/**
 * 死锁示例a b线程互相占用对方必须的资源
 *
 * @author Haotian
 * @version 1.0
 * @date 2021/3/13 19:36
 */
public class DeadThread {
    private final static String resource_a = "A";
    private final static String resource_b = "B";

    public static void deadLock() {
        Thread threadA = new Thread( () -> {
            synchronized (resource_a) {
                System.out.println( "threadA get resource a" );
                try {
                    Thread.sleep( 2000 );
                    synchronized (resource_b) {
                        System.out.println( "threadA get resource b" );
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } );

        Thread threadB = new Thread( () -> {
            synchronized (resource_b) {
                System.out.println( "threadB get resource b" );
                synchronized (resource_a) {
                    System.out.println( "threadB get resource a" );
                }
            }
        } );

        threadA.start();
        threadB.start();
    }

    public static void main(String[] args) {
        deadLock();
    }
}
