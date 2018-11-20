package com.smxy.controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.smxy.pojo.Sensor;
import com.smxy.service.SensorService;
import com.smxy.service.UserService;

public class sensorDateConvey implements Runnable{
	
    @Autowired
  	SensorService SensorService;

private String user="root";
private String password="12345";
private String jdbcUrl="jdbc:mysql://47.107.55.142:3306/kyf";
private String driver="com.mysql.jdbc.Driver";
private Connection conn=null;
private String ins="insert into kyf_sensor values(?,?,?,?,?)";
private PreparedStatement pst=null;

private BufferedReader reader;

private Socket socket;

private InputStream in;
public sensorDateConvey(Socket clientSocket) throws IOException
{
	
	try {
		socket = clientSocket;
		in = new DataInputStream(socket.getInputStream());
		this.conn=DriverManager.getConnection(jdbcUrl, user, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void insert(String TEM,String HUM,String SMO) throws ParseException{
	try {
			pst=conn.prepareStatement(ins);
			Date date = new Date();
			  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        String TIME = sdf.format(date);
		    pst.setInt(1, 0);
			pst.setString(2, TEM);
			pst.setString(3, HUM);
			pst.setString(4, SMO);
			pst.setString(5, TIME);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

public void run() {
    try {
        InputStream in = new DataInputStream(socket.getInputStream());
        byte[] msg = new byte[24];
        String message = null;
        boolean flag=true;
        int count=0;
        while (flag) {
        	  in.read(msg);
              String str=new String(msg).trim();
  	          String s[]=str.split("#");
  	          Date date = new Date();
  	          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  String TIME = sdf.format(date);
			  System.out.println("***********"+s[0]+" "+s[1]+" "+s[2]+"%");
  	       if(s[0]!=null) {
  	    	   if(Integer.parseInt(s[0])>=20&&Integer.parseInt(s[0])<=50&&s[2].length()==4) {
  	    		 System.out.println(s[0]+" "+s[1]+" "+s[2]+"%");
  	    		 insert(s[0], s[1], s[2]);
  	    	   }
  	       }
        }
        in.close();
        socket.close(); 
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
     
 
    }
}

}