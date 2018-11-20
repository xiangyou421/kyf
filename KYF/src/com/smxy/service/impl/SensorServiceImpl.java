package com.smxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smxy.mapper.SensorMapper;
import com.smxy.mapper.UserMapper;
import com.smxy.pojo.Sensor;
import com.smxy.pojo.User;
import com.smxy.service.SensorService;
import com.smxy.service.UserService;

@Service
@Transactional
public class SensorServiceImpl implements SensorService{
	@Autowired
    private SensorMapper sensorMapper;
    /**
     * 娉ㄥ唽
     * 澧炲姞鐢ㄦ埛
     */
	public void inSensor(Sensor sensor) {
		// TODO Auto-generated method stub
		sensorMapper.insertSensor(sensor);
	}
	@Override
    public List<Sensor> listSensor() {
        return sensorMapper.listSensor();
    }
	
}
