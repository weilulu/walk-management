package com.walk.management.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walk.management.user.mapper.UserMapper;
import com.walk.user.entity.WalkUser;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public int addUser(String userName,String pwd){
		int count = userMapper.addUser(userName,pwd);
		return count;
	}
	public WalkUser getUser(String userName,String pwd){
		return userMapper.getUser(userName,pwd);
		
	}
}
