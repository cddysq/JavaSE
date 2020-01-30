package com.javase.study.Lambda;

import java.text.DecimalFormat;
import java.util.function.Function;

/**
 * @Author: Haotian
 * @Date: 2020/1/30 13:28
 * @Description: Function<T, R>接口通常用于对参数进行处理，转换(处理逻辑由Lambda表达式实现)，然后返回一个新的值
 **/
public class FunctionTest {
    public static void main(String[] args) {
        String s = "艾莉丝,18";
        convert( s, c -> c.split( "," )[1], Integer::parseInt, c -> c + 70 );

        MyMoney myMoney = new MyMoney( 999999999 );
        Function<Integer, String> myMoneyFormat = i -> new DecimalFormat( "#,###" ).format( i );
        //函数式编程链式调用
        myMoney.printMoney( myMoneyFormat.andThen( i -> "CNY=" + i ) );

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

/**
 * 金钱转换类，明确作用为金钱转换符合function接口
 */
class MyMoney {
    private final int money;

    public MyMoney(int money) {
        this.money = money;
    }

    public void printMoney(Function<Integer, String> moneyFormat) {
        System.out.println( "我的存款为：" + moneyFormat.apply( this.money ) );
    }
}