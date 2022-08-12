package com.sunnaiyu.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Ch07 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("192.168.74.62",10000);
        OutputStream os = socket.getOutputStream();
        os.write("helloTcp".getBytes());

        InputStream is = socket.getInputStream();
        byte[] by=new byte[1024];
        int len = is.read(by);
        String s=new String(by,0,len);
        System.out.println("客户端："+s);
        socket.close();
    }
}
