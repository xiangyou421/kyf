package com.smxy.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;


public class portListener extends HttpServlet implements ServletContextListener{
	public void contextDestroyed(ServletContextEvent arg0) {

	}
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("-----------------SensorServer thread--------------------------");
		//gps�ػ��߳�
		System.out.println("-----------------�˿ڼ���������--------------------------");

		StartThread s=new StartThread();

		s.setDaemon(true);// �����߳�Ϊ��̨�̣߳�tomcat���ᱻhold,��������Ȼһֱ������

		s.start();
	}
}