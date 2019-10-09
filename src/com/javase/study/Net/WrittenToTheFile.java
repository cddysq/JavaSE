package com.javase.study.Net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author：Haotian
 * @Date：2019/10/9 15:41
 */
public class WrittenToTheFile {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket( 8888 );
        Socket socket = serverSocket.accept();
        BufferedWriter bw = new BufferedWriter( new FileWriter( "resources/tcp.txt" ) );
        BufferedReader br = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );

        String line;
        while ((line = br.readLine()) != null) {
            bw.write( line );
            bw.newLine();
            bw.flush();
        }
        bw.close();
        socket.close();
        serverSocket.close();
    }
}
