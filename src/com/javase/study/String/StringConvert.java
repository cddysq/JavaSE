package com.javase.study.String;

/**
 * String当中与转换相关的常用方法：
 * public char[] toCharArray()：将当前字符串拆分成为新的字符数组作为返回值。
 * public byte[] getBytes()：获取当前字符串底层的字节数组。
 * public String replace(CharSequence oldString,CharSequence newString):
 * 将所有出现的老字符串替换为新的字符串，返回替换之后的新字符串。
 * 分割字符串的方法：
 * public String[] split(String regex);按照参数的规则，将字符串切分为若干。
 * 注意：split方法的参数其实是一个正则表达式。
 */
public class StringConvert {
    public static void main(String[] args) {
        //转换成为字符数组
        char[] chars = "Hello".toCharArray();
        System.out.println(chars[0]);
        System.out.println(chars.length);
        System.out.println("=================================");

        //转换成为字节数组
        byte[] bytes = "abc".getBytes();//转换成为'a','b','c'
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        System.out.println("=================================");

        //字符替换，例如用于不良言语处理
        String say = "你妈死了，你爸死了，毛病，不会玩,玩你妈逼！";
        String Handle = "*";
        String say2 = say.replace("妈", Handle).replace("爸", Handle).
                replace("死", Handle).replace("逼", Handle).replace("毛病", Handle);
        System.out.println(say2);
        System.out.println("=================================");

        //拆分字符
        String split = "aaa.bbb.ccc";
        String[] array = split.split("\\.");//.需要使用转义
        System.out.println("数组长度为=" + array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
