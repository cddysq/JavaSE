package com.javase.study.Stream;

import java.util.ArrayList;

/**
 * 练习:集合元素处理（传统方式）
 * 现在有两个ArrayList集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）依次进行以下若干操作步骤：
 * 1. 第一个队伍只要名字为4个字的成员姓名；存储到一个新集合中。
 * 2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
 * 3. 第二个队伍只要姓艾的成员姓名；存储到一个新集合中。
 * 4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
 * 5. 将两个队伍合并为一个队伍；存储到一个新集合中。
 * 6. 根据姓名创建Person对象；存储到一个新集合中。
 * 7. 打印整个队伍的Person对象信息。
 */
public class Case_Stream {
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
        ArrayList<String> one1 = new ArrayList<>();
        for (String name : one) {
            if (name.length() == 4) {
                one1.add( name );
            }
        }
        //2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
        ArrayList<String> one2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            one2.add( one1.get( i ) );//i = 0,1,2
        }
        //第二只队伍
        ArrayList<String> two = new ArrayList<>();
        two.add( "艾露莎·舒卡勒托" );
        two.add( "艾斯德斯" );
        two.add( "我妻由乃" );
        two.add( "鞠川静香" );
        two.add( "艾尔芙蕾妲·谬亚斯德托" );
        //3. 第二个队伍只要姓艾的成员姓名；存储到一个新集合中。
        ArrayList<String> two1 = new ArrayList<>();
        for (String name : two) {
            if (name.startsWith( "艾" )) {
                two1.add( name );
            }
        }
        //4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
        ArrayList<String> two2 = new ArrayList<>();
        for (int i = 2; i < two1.size(); i++) {
            two2.add( two1.get( i ) );
        }
        //5. 将两个队伍合并为一个队伍；存储到一个新集合中。
        ArrayList<String> all = new ArrayList<>();
        all.addAll( one2 );
        all.addAll( two2 );
        //6. 根据姓名创建Person对象；存储到一个新集合中。
        ArrayList<Person> list = new ArrayList<>();
        for (String name : all) {
            list.add( new Person( name ) );
        }
        //7. 打印整个队伍的Person对象信息。
        for (Person name : list) {
            System.out.println( name );
        }
    }
}
