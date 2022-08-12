package com.sunnaiyu.test;

import java.io.IOException;
import java.net.*;

public class Ch01 {

    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket();//192.168.74.62  172.20.10.11
        byte[] bytes = "hello UDP".getBytes();

        DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length, InetAddress.getByName("192.168.74.62"),10086);
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
   // DatagramPacket datagramPacket=new DatagramPacket();

}
