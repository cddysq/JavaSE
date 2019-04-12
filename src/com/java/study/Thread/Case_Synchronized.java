package com.java.study.Thread;

/**
 * 多线程卖票程序
 * 需要考虑线程安全，保证数据不会冲突
 */
public class Case_Synchronized {
    public static void main(String[] args) {
        RunnbaleImpl r = new RunnbaleImpl();
        Thread t0 = new Thread( r );
        t0.start();
        new Thread( r ).start();
        new Thread( r, "t2" ).start();
    }
}

class RunnbaleImpl implements Runnable {
    int ticket = 100;

    @Override
    public void run() {
        while (true) {
            payTicket();
            /*同步代码块
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println( "这是买的第" + ticket + "张票" );
                    ticket--;
                }
            }*/
        }
    }

    //同步方法
    public synchronized void payTicket() {
        if (ticket > 0) {
            System.out.println( Thread.currentThread().getName() + "这是买的第" + ticket + "张票" );
            ticket--;
        }
    }
}
