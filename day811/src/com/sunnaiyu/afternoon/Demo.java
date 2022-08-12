package com.sunnaiyu.afternoon;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
手写tomcat

C/S架构：Client/Server客户端/服务器

B/S架构：Browser/Server浏览器/服务器

移动互联：手机端为主：C/S架构
java主要做的是架构中的Server端。

1.静态资源：所有用户访问后，得到的结果都是一样的，Html
2.动态资源，每个用户访问后，得到的结果可能都不一样，爱奇艺

Web服务器
接收用户的请求，处理请求，给出响应。

通过浏览器来访问我们的ServerSocket服务器，我们通过浏览器给我们的Serversocket服务器发起了请求
我要访问服务器！！！
通过IP地址+端口号
本机的IP地址：
1.cmd---ipconfig
2.127.0.0.1--本机
3.localhost---本机（前提条件：你的电脑要联网，激活一下网卡）

我们通过浏览器访问我们的ServerSocket，得到了一些信息，看不懂
其实发送过来的信息，报文，浏览器传递过来的一些信息。
User-Agent:告诉服务器我是从什么地方过来的
Host: 127.0.0.1:8080：主机地址，目标主句

貌似浏览器也是通过Socket和我们的服务器建立了TCP连接

我们不妨把浏览器给我们的服务器发送的信息称之为请求
而且这个请求格式满足了http的协议。

请求：客户端-->服务器
响应：服务器-->客户端

我需要给浏览器一个响应！！

我们一般情况下给浏览器做出响应要遵循浏览器的格式要求：
响应的基本格式：
HTTP/1.1 200 OK
Content-Length: 39
Content-Type: text/html;charset=UTF-8

<h1<h1>hello server</h1>
第一行，服务器告诉浏览器，我们这个请求成功了
第二行和第三行:是服务器告诉浏览器，我们这个响应的类型是个HTML，长度是39字符
最后一行，具体的网页数据。

* */
public class Demo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);
        //等待客户端的连接
        Socket accept=serverSocket.accept();
        //获取一个输入流来读取客户端发送的数据
        InputStream inputStream = accept.getInputStream();
        byte[] buf=new byte[1024];
        int len;
        while ((len=inputStream.read(buf))!=-1){
            System.out.println(new String(buf,0,len));
        }
        //按照http协议
        String response="HTTP/1.1 200 OK\r\n"+
                "Content-Length: 39\r\n"+
                "Content-Type: text/html;charset=UTF-8\r\n\r\n"+
                "<h1>hello server</h1>";
        inputStream.close();
        accept.close();
    }

}
