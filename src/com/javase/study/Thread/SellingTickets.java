package com.javase.study.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：Haotian
 * @Date：2019/10/8 13:56
 */
public class SellingTickets implements Runnable {
    private int ticket = 1000;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            //synchronized (this) {
            lock.lock();
            if (this.ticket > 0) {
                try {
                    Thread.sleep( 10 );
                    System.out.println( Thread.currentThread().getName() + "正在卖第" + this.ticket + "张票" );
                    this.ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        SellingTickets st = new SellingTickets();
        new Thread( st, "黄牛" ).start();
        new Thread( st, "官方人员" ).start();
        new Thread( st, "APP" ).start();
    }
}

