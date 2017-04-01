package com.walk.management.user.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.walk.user.entity.WalkUser;

@Mapper
public interface UserMapper {

	@Insert("INSERT INTO walk_user(userName,pwd) VALUES(#{userName},#{pwd})")
	int addUser(@Param("userName")String userName,@Param("pwd")String pwd);
	
	@Select("SELECT * FROM walk_user where userName=#{userName} and pwd=#{pwd} limit 0,1")
	WalkUser getUser(@Param("userName")String userName,@Param("pwd")String pwd);
}
