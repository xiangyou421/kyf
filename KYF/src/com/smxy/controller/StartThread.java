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
            System.out.println("�˿��ѿ���");
            Socket socket = null;
            Socket list[]=new Socket[100];
            int id=1;
            while(true){
            
                //ѭ�������ͻ��˵�����
            	Socket clientSocket = SERVER_SOCKET.accept();
                //�½�һ���߳�ServerSocket��������
             // ����zithread����,ͨ��socket����ͨ��
                
                Thread t = new Thread(new sensorDateConvey(clientSocket));
                t.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}