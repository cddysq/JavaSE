package com.javase.study.Stream;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: Haotian
 * @Date: 2020/1/30 14:33
 * @Description: Stream流是JDK1.8之后出现的, 关注的是做什么, 而不是怎么做
 **/
public class Test_Stream {
    public static void main(String[] args) {
        //使用Stream流的方式,遍历集合,对集合中的数据进行过滤
        //创建一个List集合,存储姓名
        List<String> list = new ArrayList<>();
        list.add( "张无忌" );
        list.add( "周芷若" );
        list.add( "赵敏" );
        list.add( "张强" );
        list.add( "张三丰" );

        //对list集合中的元素进行过滤,只要以张开头的元素,存储到一个新的集合中
        //对listA集合进行过滤,只要姓名长度为3的人,存储到一个新集合中
        //遍历listB集合
        list.stream()
                .filter( name -> name.startsWith( "张" ) )
                .filter( name -> name.length() == 3 )
                .forEach( System.out::println );

        Person p = new Person( "张三" );
        Stream.of( p ).forEach( System.out::println );
    }

    @Test
    public void demo() {
        String str = "My Name is Rainbow Cat";

        //把每个单词的长度打出来
        Stream.of( str.split( " " ) )
                .map( String::length )
                .forEach( s -> System.out.print( s + " " ) );

        //flatMap A → B属性(是个集合),最终得到所有A元素里面所有B属性集合
        //intStream/longStream 并不是Stream的子类，所以要进行装箱boxed
        Stream.of( str.split( " " ) )
                .flatMap( s -> s.chars().boxed() )
                .forEach( s -> System.out.print( (char) s.intValue() + " " ) );

        //peek 用于debug.是中间操作，forEach 是终止操作
        System.out.println( "---------------peek--------------" );
        Stream.of( str.split( " " ) )
                .peek( s -> System.out.print( s + " " ) )
                .forEach( s -> System.out.println( s + " " ) );

        //limit 限制操作，主要用于无限流
        new Random().ints().filter( s -> s > 100 && s < 1000 )
                .limit( 4 )
                .forEach( System.out::println );

        //使用并行流,普通forEach不能保证顺序
        str.chars().parallel().forEach( s -> System.out.print( (char) s ) );
        System.out.println();
        //forEachOrdered 可以保证顺序
        str.chars().parallel().forEachOrdered( s -> System.out.print( (char) s ) );
        System.out.println();

        //collect 收集为list
        List<String> list = Stream.of( str.split( " " ) ).collect( Collectors.toList() );
        System.out.println( list );

        //reduce 拼接字符串
        Optional<String> reduce = Stream.of( str.split( " " ) ).reduce( (s1, s2) -> s1 + "|" + s2 );
        System.out.println( reduce.orElse( "" ) );
        //带初始化值的 reduce ，求单词总长度
        Integer numLength = Stream.of( str.split( " " ) )
                .map( String::length )
                .reduce( 0, Integer::sum );
        System.out.println( numLength );

        //max 的使用
        Optional<String> max = Stream.of( str.split( " " ) ).max( Comparator.comparingInt( String::length ) );
        System.out.println( max.get() );

        //findFirst 拿到第一个进行终止操作
        OptionalInt first = new Random().ints().findFirst();
        System.out.println( first.getAsInt() );
    }

    @Test
    public void parallelDemo1() {
        //调用 parallel 产生并行流 为了让中间操作执行加入max终止操作
        IntStream.range( 1, 100 ).parallel().peek( Test_Stream::debug1 ).max();
    }

    @Test
    public void parallelDemo2() {
        //现在想要实现这样一个效果，先并行操作，再串行操作
        //结果得到多次调用 parallel/sequential 以结果最后一次为准
        IntStream.range( 1, 100 )
                //调用 parallel 产生并行流
                .parallel().peek( Test_Stream::debug1 )
                //调用 sequential 产生串行流
                .sequential().peek( Test_Stream::debug2 )
                .max();
    }

    @Test
    public void parallelDemo3() {
        //并行流使用的线程池：ForkJoinPool.commonPool
        //默认的线程数是当前机器的核心数
        //使用这个属性可以修改默认的线程数
        System.setProperty( "java.util.concurrent.ForkJoinPool.common.parallelism", "20" );
        IntStream.range( 1, 100 ).parallel().peek( Test_Stream::debug1 ).max();
    }

    @Test
    public void parallelDemo4() {
        //使用自己的线程池, 不使用默认线程池, 防止任务被阻塞
        //线程名字：ForkJoinPool-1
        ForkJoinPool pool = new ForkJoinPool( 20 );
        pool.submit( () -> {
            IntStream.range( 1, 100 ).parallel().peek( Test_Stream::debug1 ).max();
        } );
        pool.shutdown();
        //等待一下，防止主线程退出
        synchronized (pool) {
            try {
                pool.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void debug1(int number) {
        System.out.println( Thread.currentThread().getName() + " debug " + number );
        try {
            TimeUnit.SECONDS.sleep( 2 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void debug2(int number) {
        System.err.println( "debug " + number );
        try {
            TimeUnit.SECONDS.sleep( 2 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}