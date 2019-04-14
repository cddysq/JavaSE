package com.javase.study.File;

import java.io.*;

/*
    使用缓冲流进行文件复制
    文件复制的步骤:
        1.创建字节缓冲输入流对象,构造方法中传递字节输入流
        2.创建字节缓冲输出流对象,构造方法中传递字节输出流
        3.使用字节缓冲输入流对象中的方法read,读取文件
        4.使用字节缓冲输出流中的方法write,把读取的数据写入到内部缓冲区中
        5.释放资源(会先把缓冲区中的数据,刷新到文件中)

    文件的大小:12,603,392字节
    一次读写一个字节:357毫秒
    使用数组缓冲读取多个字节,写入多个字节:22毫秒
 */
public class CopyFiles {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        //1.创建字节缓冲输入流对象,构造方法中传递字节输入流
        BufferedInputStream bis = new BufferedInputStream( new FileInputStream( "D:\\迅雷下载\\海王.mkv" ) );
        //2.创建字节缓冲输出流对象,构造方法中传递字节输出流
        BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream( "F:\\Java\\学习笔记\\Java\\File\\copy.mkv" ) );
        //3.使用字节缓冲输入流对象中的方法read,读取文件
        //一次读取一个字节写入一个字节的方式
        /*int len = 0;
        while((len = bis.read())!=-1){
            bos.write(len);
        }*/

        //使用数组缓冲读取多个字节,写入多个字节,缓存区大小影响速度快慢
        byte[] bytes = new byte[1024 * 100];
        int len = 0;
        while ((len = bis.read( bytes )) != -1) {
            bos.write( bytes, 0, len );
        }

        bos.close();
        bis.close();

        long e = System.currentTimeMillis();
        System.out.println( "复制文件共耗时:" + ((e - s) / 1000) + "秒" );
    }
}
