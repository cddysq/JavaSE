package com.javase.study.Net.FileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * 文件上传案例服务器端:读取客户端上传的文件,保存到服务器的硬盘,给客户端回写"上传成功"
 * 明确:
 * 数据源:客户端上传的文件
 * 目的地:服务器的硬盘 d:\\upload\\1.jpg
 * 注意事项：
 * 1.为了提高效率，使用对应的输入输出缓冲流
 * 2.服务器应该一直启动
 * 3.可能多台主机同时向服务器上传文件，应该开启多线程
 * 4.保存文件路径不存在时，自动创建
 * 5.文件名自动生成
 */
public class TCPService {
    public static void main(String[] args) throws IOException {
        //1.创建一个服务器ServerSocket对象,和系统要指定的端口号
        ServerSocket service = new ServerSocket( 8888 );
        //统计上传次数
        int count = 0;
         /*
            让服务器一直处于监听状态(死循环accept方法)
            有一个客户端上传文件,就保存一个文件
         */
        while (true) {
            //2.使用ServerSocket对象中的方法accept,获取到请求的客户端Socket对象
            Socket socket = service.accept();
            /*
                使用多线程技术,提高程序的效率
                有一个客户端上传文件,就开启一个线程,完成文件的上传
             */
            new Thread( () -> {
                try {
                    receiveFiles( socket );
                } catch (IOException e) {
                    System.out.println( e );
                }
            } ).start();
            count++;
            System.out.println( "第" + count + "次接受文件成功" );
        }
        /*服务器不用关闭
        service.close();*/
    }

    private static void receiveFiles(Socket socket) throws IOException {
        //3.使用Socket对象中的方法getInputStream,获取到网络字节输入流InputStream对象
        BufferedInputStream bis = new BufferedInputStream( socket.getInputStream() );
        //4.判断F:\Java\学习笔记\Java\File件夹是否存在,不存在则创建
        File file = new File( "F:\\Java\\学习笔记\\Java\\File\\Upload" );
        if (!file.exists()) {
            file.mkdirs();
        }
        /*
           自定义一个文件的命名规则:防止同名的文件被覆盖
           规则:域名+毫秒值+随机数
        */
        String fileName = "yileaf" + System.currentTimeMillis() + new Random().nextInt( 666666 ) + ".mp3";
        //5.创建一个本地字节输出流FileOutputStream对象,构造方法中绑定要输出的目的地
        BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream( file + "\\" + fileName ) );
        //6.使用网络字节输入流InputStream对象中的方法read,读取客户端上传的文件
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read( bytes )) != -1) {
            //7.使用本地字节输出流FileOutputStream对象中的方法write,把读取到的文件保存到服务器的硬盘上
            bos.write( bytes, 0, len );
        }
        //8.使用Socket对象中的方法getOutputStream,获取到网络字节输出流OutputStream对象
        //9.使用网络字节输出流OutputStream对象中的方法write,给客户端回写"上传成功"\
        socket.getOutputStream().write( "上传成功".getBytes() );
        //10.释放资源(OutputStream,Socket,ServerSocket)
        bos.close();
        socket.close();
    }
}
