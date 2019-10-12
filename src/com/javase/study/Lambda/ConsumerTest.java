package com.javase.study.Lambda;

import java.util.function.Consumer;

/**
 * @Author：Haotian
 * @Date：2019/10/12 10:34
 */
public class ConsumerTest {
    public static void main(String[] args) {
        String[] str = {"艾莉丝,18", "达尔文,20"};
        printInfo( str, s -> System.out.println( "姓名：" + s.split( "," )[0] ), s -> System.out.println( "年龄：" + s.split( "," )[1] ) );
    }

    /**
     * 按照指定格式输出
     *
     * @param str  数据源
     * @param con1 第一次处理
     * @param con2 第二次处理
     */
    private static void printInfo(String[] str, Consumer<String> con1, Consumer<String> con2) {
        for (String s : str) {
            con1.andThen( con2 ).accept( s );
        }
    }
}
