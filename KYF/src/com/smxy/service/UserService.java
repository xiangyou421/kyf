package com.smxy.service;

import java.util.List;

import com.smxy.pojo.User;
import com.smxy.util.Page;

public interface UserService {

	User login(String name, String password);

	void register(User user);

	User findByName(String name);
}
