package com.smxy.controller;

import java.net.ServerSocket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class StartThread extends Thread {
	private static ServerSocket SERVER_SOCKET =null;
	public void run() {
		try {
        	SERVER_SOCKET = new ServerSocket(9704);
            System.out.println("端口已开启");
            Socket socket = null;
            Socket list[]=new Socket[100];
            int id=1;
            while(true){
            
                //循环监听客户端的连接
            	Socket clientSocket = SERVER_SOCKET.accept();
                //新建一个线程ServerSocket，并开启
             // 创建zithread对象,通过socket连接通信
                
                Thread t = new Thread(new sensorDateConvey(clientSocket));
                t.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}