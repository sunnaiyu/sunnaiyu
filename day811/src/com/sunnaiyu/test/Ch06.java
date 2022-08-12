package com.sunnaiyu.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ch06 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(10000);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        byte[] by=new byte[1024];
        int read = is.read(by);
        String s=new String(by,0,read);
        System.out.println(s);
        socket.close();
        is.close();
        ss.close();


    }
}
