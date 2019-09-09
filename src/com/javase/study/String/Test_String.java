package com.javase.study.String;

/**
 * String字符对象
 * ==是进行对象地址比较，如果需要字符串内容比较，可以使用equals
 */
public class Test_String {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String( charArray );

        System.out.println( str1 == str2 );
        System.out.println( str1 == str3 );//==用于对象地址比较，str3使用new创建，地址已经改变

        System.out.println( str1.equals( str2 ) );
        System.out.println( str1.equals( str3 ) );

        String str4 = "hello";
        System.out.println( str1.equals( str4 ) );//equals进行内容比较区分大小写
        System.out.println( "=========================" );

        String str5 = null;
        System.out.println( "abc".equals( str5 ) );//推荐写法
        //System.out.println(str5.equals("abc"));//不推荐：报异常，空指针NullPointerException
        System.out.println( "=========================" );

        String strA = "Java";
        String strB = "java";
        System.out.println( strA.equals( strB ) );
        System.out.println( strA.equalsIgnoreCase( strB ) );//equalsIgnoreCase忽略大小写（英文下的大小写）

        convert();
    }

    public static void convert() {
        System.out.println( "=========================" );
        //基本类型 -> 字符串(String)
        int i1 = 100;
        //直接加上""为最常用转换写法
        String s1 = i1 + "";
        System.out.println( s1 + 200 );

        String s2 = Integer.toString( 100 );
        System.out.println( s2 + 20 );

        String s3 = String.valueOf( 100 );
        System.out.println( s3 + 1000 );

        //字符串 -> 基本类型，需要注意数据类型相同问题
        int i = Integer.parseInt( s1 );
        System.out.println( i - 20 );

    }
}
