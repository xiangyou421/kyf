package com.smxy.service;

import java.util.List;

import com.smxy.pojo.Sensor;
import com.smxy.pojo.User;
import com.smxy.util.Page;

public interface SensorService {
	 void inSensor(Sensor sensor);
	 List<Sensor> listSensor();
}
