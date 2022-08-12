package com.sunnaiyu.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Ch02 {
    public static void main(String[] args) throws IOException {
        DatagramSocket db=new DatagramSocket(10086);//创建socket对象
        byte[] by=new byte[1024];//定义一个数组定义容量
        DatagramPacket dp=new DatagramPacket(by,by.length);//创建一个包来接收数据
        db.receive(dp);//接收数据
        byte[] data = dp.getData();//将获取的数据转为数组
        int length = dp.getLength();//获取数据的长度
        String s=new String(data,0,length);
        System.out.println(s);
    }
}
