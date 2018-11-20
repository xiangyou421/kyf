package com.smxy.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.smxy.pojo.Sensor;
import com.smxy.pojo.User;
import com.smxy.service.SensorService;
import com.smxy.service.UserService;
import com.smxy.util.Page;
 


@Controller
@Scope("prototype")
@RequestMapping("")
public class SensorController {
    @Autowired
    SensorService sensorService;
    
    @RequestMapping(value="/listSensor.do",method=RequestMethod.GET)
    public @ResponseBody
    String listSensor () {
        List<Sensor> listSensor = sensorService.listSensor();
        String jsonString = JSON.toJSONString(listSensor);
        return jsonString;
    }
    
   
}