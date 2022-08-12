package com.sunnaiyu.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Ch04 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds=new DatagramSocket(12345);
        while (true){
            byte[] by=new byte[1024];
            DatagramPacket dp=new DatagramPacket(by,by.length);

            ds.receive(dp);
            byte[] data = dp.getData();
            int length = dp.getLength();
            String s=new String(data,0,length);
            System.out.println(s);
        }

        //ds.close();
    }
}
