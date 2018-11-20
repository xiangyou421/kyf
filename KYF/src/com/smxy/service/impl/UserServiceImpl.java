package com.smxy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smxy.mapper.UserMapper;
import com.smxy.pojo.User;
import com.smxy.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
    private UserMapper userMapper;
    /**
     * 鐧诲綍
     * 鏍规嵁鐢ㄦ埛鍚嶅拰瀵嗙爜杩涜鏌ヨ
     */
    @Override
    public User login(String username, String password) {
        return userMapper.findByUserNameAndPassword(username, password);
    }
    /**
     * 娉ㄥ唽
     * 澧炲姞鐢ㄦ埛
     */
    @Override
    public void register(User user) {
        userMapper.addUser(user);    
    }
    /**
     * 鏍规嵁鐢ㄦ埛鍚嶆煡璇�
     */
    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }
}
