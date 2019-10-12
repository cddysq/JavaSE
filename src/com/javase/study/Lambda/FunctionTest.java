package com.javase.study.Lambda;

import java.util.function.Function;

/**
 * @Author：Haotian
 * @Date：2019/10/12 14:54
 */
public class FunctionTest {
    public static void main(String[] args) {
        String s = "艾莉丝,18";
        convert( s, c -> c.split( "," )[1], Integer::parseInt, c -> c + 70 );
    }

    /**
     * Function<a,b>用于类型转换 a -> b
     *
     * @param s  数据源
     * @param f1 第一次转换
     * @param f2 第二次转换
     * @param f3 第三次扎转换
     */
    public static void convert(String s, Function<String, String> f1, Function<String, Integer> f2, Function<Integer, Integer> f3) {
        Integer number = f1.andThen( f2 ).andThen( f3 ).apply( s );
        System.out.println( number );
    }
}
