package com.javase.study.Thread;

import com.javase.study.util.UnsafeInstance;

/**
 * @author Haotian
 * @version 1.0
 * @date 2021/3/15 20:26
 * 并发场景下存在指令重排案例，通过内存屏障防止指令重排
 */
public class VolatileSample {
    private static int x = 0, y = 0;
    /*private volatile static int a = 0, b = 0;*/
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;

        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread t1 = new Thread( new Runnable() {
                @Override
                public void run() {
                    // 由于线程t1先启动，下面这句话让它等一等线程t2. 读着可根据自己电脑的实际性能适当调整等待时间.
                    shortWait( 10000 );
                    // 是读还是写？store，volatile写
                    a = 1;
                    // storeload ,读写屏障，不允许volatile写与第二部volatile读发生重排
                    // 手动加内存屏障
                    UnsafeInstance.reflectGetUnsafe().storeFence();
                    // 分两步进行，第一步先volatile读，第二步再普通写
                    x = b;
                }
            } );
            Thread t2 = new Thread( () -> {
                b = 1;
                UnsafeInstance.reflectGetUnsafe().storeFence();
                y = a;
            } );
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            // 正常结果：1,1 0,1 1,0
            // cpu或者jit对我们的代码进行了指令重排：0,0
            String result = "第" + i + "次 (" + x + "," + y + "）";
            if (x == 0 && y == 0) {
                System.err.println( result );
                break;
            } else {
                System.out.println( result );
            }
        }
    }

    public static void shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }
}
