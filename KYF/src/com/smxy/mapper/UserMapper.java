package com.smxy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.smxy.pojo.User;
import com.smxy.util.Page;

public interface UserMapper {
    User findByUserNameAndPassword(@Param("name")String name,@Param("password")String password);
    void addUser(User user);
    User findByName(String username);
     
}
