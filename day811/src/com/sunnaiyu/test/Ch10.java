package com.sunnaiyu.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Ch10 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(10000);
        Socket s = ss.accept();
        BufferedReader bf=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;
        while ((line=bf.readLine())!=null){
            System.out.println(line);
        }
        s.close();
        ss.close();
    }
}
