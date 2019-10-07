package com.javase.study.File;

import java.io.*;

/**
 * 文件复制，一读一写
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        File file = new File( "E:\\demo" );
        File newFile = new File( "F:\\Java\\学习笔记\\Java" );
        copyFolder( file, newFile );
    }

    /**
     * 复制文件夹
     *
     * @param file    原文件名
     * @param newFile 新文件名
     * @throws IOException
     */
    private static void copyFolder(File file, File newFile) throws IOException {
        //判断是否为目录
        if (file.isDirectory()) {
            //是目录获取目录名
            String fileName = file.getName();
            //拼接目录名
            File newFolder = new File( newFile, fileName );
            //目录不存在则创建
            if (!newFolder.exists()) {
                newFolder.mkdir();
            }
            //获取当前目录下的所有文件
            File[] files = file.listFiles();
            //遍历
            assert files != null;
            for (File f : files) {
                //如果还存在文件夹，递归创建
                copyFolder( f, newFolder );
            }
        } else {
            //不是目录进行文件名拼接
            File thisFile = new File( newFile, file.getName() );
            copyFile( file, thisFile );
        }
    }

    private static void copyFile(File file, File thisFile) throws IOException {
        long s = System.currentTimeMillis();
        //1.创建一个字节输入流对象,构造方法中绑定要读取的数据源
        BufferedInputStream bis = new BufferedInputStream( new FileInputStream( file ) );
        //2.创建一个字节输出流对象,构造方法中绑定要写入的目的地
        BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream( thisFile ) );
        //使用数组缓冲读取多个字节,写入多个字节
        byte[] bytes = new byte[1024];
        //3.使用字节输入流对象中的方法read读取文件
        int len = 0;
        while ((len = bis.read( bytes )) != -1) {
            //4.使用字节输出流中的方法write,把读取到的字节写入到目的地的文件中
            bos.write( bytes, 0, len );
        }
        //5.释放资源(先关写的,后关闭读的;如果写完了,肯定读取完毕了)
        bos.close();
        bis.close();
        long e = System.currentTimeMillis();
        System.out.println( "复制文件总耗时：" + (e - s) + "毫秒" );
    }
}
