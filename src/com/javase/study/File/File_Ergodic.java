package com.javase.study.File;

import java.io.File;
import java.io.FileFilter;

/**
 * File获取指定目录下的所有文件
 */
public class File_Ergodic {
    public static void main(String[] args) {
        File f1 = new File( "E:\\" );
        getAllFile( f1 );

    }

    public static void getAllFile(File dir) {
        //public File[] listFiles();返回一个File数组，表示该File目录中的所有的子文件或目录。
        if (dir.isDirectory()) {
            //传递过滤器对象，使用匿名内部类
           /* File[] files = dir.listFiles( new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    //过滤规则,pathname是文件夹或者是。txt结尾文件返回true
                    return pathname.isDirectory() || pathname.getName().toLowerCase(  ).endsWith( ".txt" );
                }
            } );*/
            //Lambda写法过滤器
            File[] files = dir.listFiles( pathname -> pathname.isDirectory() || pathname.getName().toLowerCase().endsWith( ".txt" ) );
            if (files != null) {
                for (File file : files) {
                    getAllFile( file );
                }
            }
        }
        System.out.println( dir );
    }

    private static void show2() {
        //public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
        File f2 = new File( "E:\\" );
        String[] list = f2.list();
        for (String s : list) {
            System.out.println( s );
        }
    }
}
