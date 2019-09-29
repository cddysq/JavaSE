package com.javase.study.practice;

import java.io.*;

/**
 * @Author：Haotian
 * @Date：2019/9/28 18:25
 */
public class Day04 {
    public static void main(String[] args) {
        //show1();

        //show2();
        //show3();
        //show4();
        show5();

    }

    private static void show5() {
        File file = new File( "F:\\Java\\学习笔记\\Java\\Java笔记.md" );
        if (!file.isDirectory()) {
            System.out.println( "不是一个目录" );
        }
        File f = new File( "F:\\Java\\学习笔记\\Java\\File\\HelloWord.txt" );
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println( "文件已经存在" );
        }
    }

    private static void show4() {
        try {
            FileInputStream fis = new FileInputStream( "F:\\Java\\学习笔记\\Java\\Java笔记.md" );
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read( bytes )) != -1) {
                System.out.println( new String( bytes, 0, len ) );
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在D盘下，有一HelloWord.txt 文件中内容为：HelloWorld
     * 在文件原内容基础上，添加五句 I love java，而且要实现一句一行操作(注：原文不可覆盖)。
     * 利用字节输出流对象往C盘下c.txt文件输出5句：”i love java”
     */
    private static void show3() {
        try {
            FileOutputStream fos = new FileOutputStream( "F:\\Java\\学习笔记\\Java\\File\\HelloWord.txt", true );
            String s = "i love java";
            for (int i = 0; i < 5; i++) {
                fos.write( "\r\n".getBytes() );
                fos.write( s.getBytes() );
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 利用字节输出流一次写一个字节数组的方式向D盘的b.txt文件输出内容:"i love java"。
     */
    private static void show2() {
        try {
            FileOutputStream fos = new FileOutputStream( "F:\\Java\\学习笔记\\Java\\File\\b.txt" );
            String s = "i love java";
            fos.write( s.getBytes() );
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 利用字节输出流一次写一个字节的方式，向D盘的a.txt文件输出字符‘a’
     */
    private static void show1() {
        try {
            FileOutputStream fos = new FileOutputStream( "F:\\Java\\学习笔记\\Java\\File\\a.txt" );
            fos.write( 97 );
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
