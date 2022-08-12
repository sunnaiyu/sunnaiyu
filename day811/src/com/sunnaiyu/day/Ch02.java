package com.sunnaiyu.day;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/*
UDP:不可靠的传输协议
面试题：
TCP/IP和UDP的区别。

* */
public class Ch02 {

    @Test
    public void client() throws IOException {
        DatagramSocket socket=new DatagramSocket();
        String str="我通过UDP协议发送的消息";
        byte[] data=str.getBytes();
        //构建成了一个数据报文
        //构建成了一个数据报文
        //第一个参数就是要发送的数据第二个参数从哪开始发
        //第三个参数发多长
        //第四个参数指定服务器的ip地址
        // 第五个参数是服务器的端口号
        DatagramPacket packet=new DatagramPacket(data,0,data.length, InetAddress.getLocalHost(),9999);
        //发送数据
        socket.send(packet);
        socket.close();
    }

    @Test
    public void server() throws IOException {
        DatagramSocket socket=new DatagramSocket(9999);
        byte[] buffer=new byte[1024*1024];
        DatagramPacket packet=new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));

    }
}
