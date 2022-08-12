package com.sunnaiyu.day;

import org.junit.Test;
import sun.java2d.pipe.SpanIterator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
网络编程（网络通信)

服务器:是一台电脑。是一台低配的电脑
客户端:是一台电脑，是手机，是平板，是网页。

我们即将要在我们自己的电脑上搭建服务器环境
我们自己的电脑即使服务器又是客户端。

Socket编程
Socket编程是建立在TCP/IP协议上

如何在网络环境下访问其他的主机

通过IP地址+端口号形式可以访问其他的主机。

查看自己的电脑在当前网络下的ip地址
通过指令控制台CMD：ipconfig查看ipv4地址，是当前局域网下的ip地址
192.168.0.1：8080

一台电脑可以有好多的端口号，每个端口号对应的程序也不用。
当我们通过IP地址+端口号访问一个指定的程序的时候，
192.168.0.1：8080和192.168.0.1：9999，不是一个程序，但是在一个服务器上

我们接下来就要在我们的电脑上开辟一个端口号，这个端口号就是服务器的端口号
然后我们在构建一个客户端，来通过ip地址+端口号来访问到服务器

Socket通信的服务器也是一个对象，ServerSocket类

 */
public class Ch01 {
    @Test
    public void serve() throws IOException {
        //创建了一个服务器对象，绑定在了8888端口
        ServerSocket serverSocket=new ServerSocket(8888);
        //服务器在等待客户端连接
        System.out.println("服务器已启动");
        Socket socket = serverSocket.accept();
        //System.out.println(socket);
        //读取客户端发送的信息
        InputStream inputStream = socket.getInputStream();
        //我们要再获取一个输出流，这个输出流是为了给客户端返回数据

        byte[] buffer=new byte[1024];
        int len;
        System.out.println("服务器接收信息");
        while ((len=inputStream.read(buffer))!=-1){
            System.out.println(new String (buffer,0,len));
        }
        inputStream.close();
        socket.close();
    }
    @Test
    public void client() throws IOException {
        //创建了一个socket通信的客户端
        Socket socket=new Socket();
        //第一个参数就是获取当前电脑的IP地址
        // 第二个参数就是服务器的端口号
        socket.connect(new InetSocketAddress(InetAddress.getLoopbackAddress(),8888));
        System.out.println("客户端已连接服务器");
        //客户端发送数据给服务器
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("向客户端发送信息：hello server");
        byte[] bytes = "hello server".getBytes();
        outputStream.write(bytes);
        outputStream.close();
        socket.close();
    }
}
/*
接收信息，接的是什么信息?
看输入流是怎么来的?
我们现在的输入流是怎么来的?
通过socket获取到的
socket是怎么来的?
socket是通过服务器启动之后，接到的客户端连接
我们的输入流就是客户端的输入流
因为我们现在接收的是一个文件
我们需要把这个文件另存
我们需要构建一个输出流，把这个文件保存到硬盘上

* */