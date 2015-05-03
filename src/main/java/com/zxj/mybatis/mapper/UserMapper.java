package com.zxj.mybatis.mapper;

import java.util.List;

import com.zxj.mybatis.model.User;

public interface UserMapper {
	public User selectUserByID(int id);

	public List<User> selectUsers(String userName);

	public void addUser(User user);
	
	public void updateUser(User user);

	public void deleteUser(int id);
}