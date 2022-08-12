package com.sunnaiyu.test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Ch05 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("192.168.74.62",10000);

        OutputStream os = socket.getOutputStream();

        os.write("helloTcp".getBytes());

        os.close();
        socket.close();

    }
}
