package com.sunnaiyu.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ch08 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(10000);
        Socket socket = ss.accept();
        byte[] by=new byte[1024];
        InputStream is = socket.getInputStream();
        int len = is.read(by);
        String s=new String (by,0,len);
        System.out.println("客户端："+s);

        OutputStream os = socket.getOutputStream();
        os.write("服务端接收到了数据，".getBytes());
        socket.close();
        ss.close();

    }
}
