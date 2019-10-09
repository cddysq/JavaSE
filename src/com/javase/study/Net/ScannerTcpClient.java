package com.javase.study.Net;

import java.io.*;
import java.net.Socket;

/**
 * @Author：Haotian
 * @Date：2019/10/9 15:24
 */
public class ScannerTcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket( "127.0.0.1", 8888 );

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream() ) );

        String line;
        while ((line = br.readLine()) != null) {
            if ("886".equals( line )) {
                break;
            }
            bw.write( line );
            bw.newLine();
            bw.flush();
        }
        bw.close();
        socket.close();
    }
}
