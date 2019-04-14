package com.javase.study.File;

import java.io.File;
import java.io.IOException;

/*
    java.io.File类
    文件和目录路径名的抽象表示形式。
    java把电脑中的文件和文件夹(目录)封装为了一个File类,我们可以使用File类对文件和文件夹进行操作
    我们可以使用File类的方法
        创建一个文件/文件夹
        删除文件/文件夹
        获取文件/文件夹
        判断文件/文件夹是否存在
        对文件夹进行遍历
        获取文件的大小
    File类是一个与系统无关的类,任何的操作系统都可以使用这个类中的方法

    重点:记住这三个单词
        file:文件
        directory:文件夹/目录
        path:路径
 */
public class Test_File {
    public static void main(String[] args) throws IOException {
        /*
            static String pathSeparator 与系统有关的路径分隔符，为了方便，它被表示为一个字符串。
            static char pathSeparatorChar 与系统有关的路径分隔符。

            static String separator 与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。
            static char separatorChar 与系统有关的默认名称分隔符。

            操作路径:路径不能写死了
            C:\develop\a\a.txt  windows
            C:/develop/a/a.txt  linux
            "C:"+File.separator+"develop"+File.separator+"a"+File.separator+"a.txt"
         */
        String pathSeparator = File.pathSeparator;
        System.out.println( pathSeparator );//路径分隔符 windows:分号;  linux:冒号:

        String separator = File.separator;
        System.out.println( separator );// 文件名称分隔符 windows:反斜杠\  linux:正斜杠/

        //public boolean exists();判断路径是否存在
        File f1 = new File( "F:\\Java\\学习笔记\\Java" );
        System.out.println( f1.exists() );

        //public boolean isDirectory();判断是否为目录
        //public boolean isFile();判断是否为文件
        File f2 = new File( "F:\\Java\\学习笔记\\Java" );
        //先判断路径是否存在
        if (f2.exists()) {
            System.out.println( f2.isDirectory() );
            System.out.println( f2.isFile() );
        }

        //public boolean createNewFile();当文件不存在时，创建新文件
        //public boolean mkdirs();当文件夹不存在时，创建目录
        File f3 = new File( "F:\\Java\\学习笔记\\Java\\File" );
        if (!f3.exists()) {
            System.out.println( f3.mkdirs() );
        }
    }

}

