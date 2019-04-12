package com.java.study.String;

/**
 * String当中获取相关的常用方法有：
 * public int length():获取字符串当中含有字符的个数，拿到字符串长度。
 * public String concat(String str)：将当前字符串和参数字符串拼接返回新的字符串。
 * public char charAt(int index)：获取指定所索引位置的单个字符串。（索引从0开始）。
 * public int indexOf(String str)：查找参数字符串在本字符串出现的首次索引位置,如果没有返回-1。
 * public String substring(int index)：截取从参数位置一直到字符串末尾，返回新字符串。
 * public String substring(int begin,int end)：截取从begin开始，一直到end结束，中间的字符串。
 * 备注：[begin,end):包含左边，不包含右边。
 */
public class StringMethod {
    public static void main(String[] args) {
        //获取字符串的长度
        int length = "hcaufghaisufguaif".length();
        System.out.println("字符串的长度为：" + length);
        System.out.println("==========================");

        //拼接字符串
        String str1 = "Hello";
        String str2 = "World";
        String str3 = str1.concat(str2);
        System.out.println("新字符为：" + str3);
        System.out.println("==========================");

        //获取指定索引位置的单个字符
        char ch = "Hello".charAt(1);
        System.out.println("在一号索引位置的字符是：" + ch);
        System.out.println("==========================");

        //查找参数字符出现的首次索引位置,无为-1
        String original = "Hello World";
        int index = original.indexOf("ll");
        System.out.println("第一次索引值是：" + index);
        System.out.println("Hello".indexOf("abc"));
        System.out.println("==========================");

        //截取字符
        String strA = "Cherry Blossoms";
        String strB = strA.substring(7);
        System.out.println("初始字符为：" + strA);
        System.out.println("剩余字符为：" + strB);
        System.out.println("==========================");

        //截取指定位置字符
        String strC = strA.substring(0, 6);
        System.out.println("截取的字符为：" + strC);
    }
}
