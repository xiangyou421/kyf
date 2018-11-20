package com.smxy.test;
  
import java.util.List;
  
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.smxy.mapper.UserMapper;
import com.smxy.pojo.Sensor;
import com.smxy.pojo.User;
import com.smxy.service.SensorService;
import com.smxy.util.Page;
  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {
  
    @Autowired
  	SensorService sensorService;
    @Test
   public void listSensor() {
        List<Sensor> listSensor = sensorService.listSensor();
        for (Sensor c : listSensor) {
            System.out.println(c.getTIME());
          }
    }
    
/*    public void listSensor() {
        List<Sensor> listSensor = sensorService.listSensor();
        for (Sensor c : listSensor) {
        System.out.println(c.getHUM());
      }
    }*/
    
/*  @Test
    public void testAdd() {
	  	Sensor sensor =new Sensor();
	  	sensor.setTEM("123");
	  	sensor.setHUM("123");
	  	sensor.setSMO("123");
	  	sensor.setTIME("123");
	  	SensorService.inSensor(sensor);
    }*/

  
//    
//    @Test
//    public void testTotal() {
//        int total = categoryMapper.total();
//        System.out.println(total);
//    }
//
//    @Test
//    public void testList() {
//        Page p = new Page();
//        p.setStart(2);
//        p.setCount(3);
//        List<Category> cs=categoryMapper.list(p);
//        for (Category c : cs) {
//            System.out.println(c.getName());
//        }
//    }
  
}