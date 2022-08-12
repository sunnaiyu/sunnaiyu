package com.sunnaiyu.afternoon;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);
        System.out.println("服务器启动成功。。。。");
        Socket accept = serverSocket.accept();
        OutputStream outputStream = accept.getOutputStream();
        /*HTTP/1.1 302 Moved Temporarily
Location:https://www.baidu.com*/
        String response="HTTP/1.1 302 Moved Temporarily\r\n"+
                "Location:https://www.baidu.com\r\n\r\n";
        outputStream.write(response.getBytes());
        outputStream.flush();
        //这个流不要着急关，因为突然的关闭会导致浏览器和服务器断开连接
    }
}
