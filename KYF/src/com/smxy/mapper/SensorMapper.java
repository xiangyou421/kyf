package com.smxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smxy.pojo.Sensor;
import com.smxy.pojo.User;
import com.smxy.util.Page;

public interface SensorMapper {
   
    void insertSensor(Sensor sensor);
    List<Sensor> listSensor();
    
}
