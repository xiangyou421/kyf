package com.smxy.controller;
import java.security.MessageDigest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import com.smxy.pojo.User;
import com.smxy.service.UserService;
import com.smxy.util.Page;
 


// 鍛婅瘔spring mvc杩欐槸涓�涓帶鍒跺櫒绫�
@Controller
@Scope("prototype")
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
 
    @RequestMapping(value="/userlogin.do",method=RequestMethod.POST)
    public ModelAndView login(String name,String password,ModelAndView mv,HttpSession session) {
        User user=userService.login(name, MD5(password));

        System.out.println(MD5(password));
        if(user!=null){  
            mv.setViewName("index");
        }else { 
            mv.addObject("message","错误");
            mv.setViewName("error");
        }
        return mv;
    }
    @RequestMapping(value="/registerpage.do")
    public String registerpage() {
        
        return "user/registerpage";
    }
    /**
     * 鐢ㄦ埛娉ㄥ唽
     */
    @RequestMapping(value="/userregister.do",method=RequestMethod.POST)
    public String register(User user) {
        String name=user.getName();
        if (userService.findByName(name) == null) {
            userService.register(user);
            return "login";
        }else {
            return "error";
        }
        
    }
    @ResponseBody
    @RequestMapping("/logincheck.do")
    //@RequestMapping(value="/logincheck",method=RequestMethod.POST)
    public String appLogin(HttpServletRequest request, HttpSession session) {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        JsonObject object=new JsonObject();
        JsonArray array=new JsonArray();
        JsonObject lan1=new JsonObject();
        lan1.addProperty("states", "success");
        array.add(lan1);
        object.add("languages", array);
        String str =object.toString();
        if (name != null && password != null) {
            User user = userService.login(name, MD5(password));
            System.out.println(user);
            System.out.println(str);
            if (user != null) {
            	System.out.println(str);
                return str;
            } else {
            	System.out.println(2);
            	return JSON.toJSONString(name+"2");
            }
        } else {
        	System.out.println(3);
        	return JSON.toJSONString(name+"3");
        }
    }
    public final static String MD5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4',
                             '5', '6', '7', '8', '9',
                             'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes();
     //获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
     //使用指定的字节更新摘要
            mdInst.update(btInput);
     //获得密文
            byte[] md = mdInst.digest();
     //把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}