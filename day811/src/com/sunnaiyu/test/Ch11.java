package com.sunnaiyu.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Ch11 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(10000);
        Socket s = ss.accept();
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\idea\\javaprojectstudy\\java\\day811"));

        String line;
        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        s.close();
        ss.close();
    }
}
