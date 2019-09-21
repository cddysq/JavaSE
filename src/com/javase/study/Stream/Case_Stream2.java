package com.javase.study.Stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * 练习：集合元素处理（Stream方式）
 * 将上一题当中的传统for循环写法更换为Stream流式处理方式。
 * 两个集合的初始内容不变，Person类的定义也不变。
 */
public class Case_Stream2 {
    public static void main(String[] args) {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add( "伊卡洛斯" );
        one.add( "夏娜" );
        one.add( "三千院凪" );
        one.add( "逢坂大河" );
        one.add( "露易丝" );
        one.add( "樱井优亚" );

        //1. 第一个队伍只要名字为4个字的成员姓名；存储到一个新集合中。
        //2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
        Stream<String> oneStream = one.stream().filter( name -> name.length() == 4 ).limit( 3 );

        //第二只队伍
        ArrayList<String> two = new ArrayList<>();
        two.add( "艾露莎·舒卡勒托" );
        two.add( "艾斯德斯" );
        two.add( "我妻由乃" );
        two.add( "鞠川静香" );
        two.add( "艾尔芙蕾妲·谬亚斯德托" );

        //3. 第二个队伍只要姓艾的成员姓名；存储到一个新集合中。
        //4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
        Stream<String> twoStream = two.stream().filter( name -> name.startsWith( "艾" ) ).skip( 2 );

        //5. 将两个队伍合并为一个队伍；存储到一个新集合中。
        //6. 根据姓名创建Person对象；存储到一个新集合中。
        //7. 打印整个队伍的Person对象信息。
        //Stream.concat( oneStream, twoStream ).map( name -> new Person( name ) ).forEach( p -> System.out.println( p ) );
        Stream.concat( oneStream, twoStream ).map( Person::new ).forEach( System.out::println );
    }
}
