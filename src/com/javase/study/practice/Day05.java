package com.javase.study.practice;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author：Haotian
 * @Date：2019/10/9 18:31
 */
public class Day05 {
    @Test
    public void server() throws IOException {
        /*
        在项目下创建TCP 服务器端 端口号为8888
        1:等待客户端连接   如果有客户端连接  获取到客户端对象
        2:获取到客户端对象之后 当前在服务器读取数据客户端传送数据
         */
        ServerSocket server = new ServerSocket( 8888 );
        Socket sock = server.accept();
        InputStream is = sock.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read( bytes );
        System.out.println( (new String( bytes, 0, len )) );
        //向客户端发送”hello world”,客户端将信息输出
        OutputStream os = sock.getOutputStream();
        os.write( "hello world".getBytes() );
        os.close();
        sock.close();
        server.close();
    }

    @Test
    public void client() throws IOException {
        /*
        访问之前创建的服务器端,服务器端ip127.0.0.1 端口号8888
        1:客户端连接服务器,并发送 hello.服务器,我是客户端.
         */
        Socket socket = new Socket( "127.0.0.1", 8888 );
        OutputStream os = socket.getOutputStream();
        os.write( "hello.服务器,我是客户端".getBytes() );
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read( bytes );
        System.out.println( new String( bytes, 0, len ) );
        is.close();
        os.close();
        socket.close();
    }

    @Test
    public void uploadFile() throws IOException {
        //上传文件
        Socket socket = new Socket( "127.0.0.1", 8888 );
        FileInputStream fis = new FileInputStream( "E:\\图片\\02.jpg" );
        OutputStream os = socket.getOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read( bytes )) != -1) {
            os.write( bytes, 0, len );
        }
        socket.shutdownOutput();
        fis.close();
        socket.close();
    }

    @Test
    public void receiveFile() throws IOException {
        //接收文件
        ServerSocket server = new ServerSocket( 8888 );
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        File file = new File( "F:\\Java\\学习笔记\\Java\\upload" );
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        FileOutputStream fos = new FileOutputStream( file + "\\" + fileName );
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = is.read( bytes )) != -1) {
            fos.write( bytes, 0, len );
        }
        System.out.println( "接收完毕" );
        fos.close();
        socket.close();
        server.close();
    }
}
