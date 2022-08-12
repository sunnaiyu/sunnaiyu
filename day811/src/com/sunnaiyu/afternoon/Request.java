package com.sunnaiyu.afternoon;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
将接收的请求转化为请求对象
* */
public class Request {
    //
    private String protocol;

    public static void main(String[] args) throws UnknownHostException {
        InetAddress sunnaiyu = InetAddress.getByName("192.168.74.62");
        String hostName = sunnaiyu.getHostName();
        String hostAddress = sunnaiyu.getHostAddress();
        System.out.println(hostAddress);
        System.out.println(hostName);
    }
}
