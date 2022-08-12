package com.sunnaiyu.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Ch03 {
    public static void main(String[] args) throws IOException {
        DatagramSocket da=new DatagramSocket();

        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=bf.readLine())!=null){
            if("886".equals(str)){
                break;
            }
            byte[] by=str.getBytes();
            DatagramPacket db=new DatagramPacket(by,by.length, InetAddress.getByName("sunnaiyu"),12345);
            da.send(db);
        }
        da.close();
    }
}
