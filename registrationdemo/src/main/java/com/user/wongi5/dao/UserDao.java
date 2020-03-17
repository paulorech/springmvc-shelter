package com.user.wongi5.dao;

import java.util.List;

import com.user.wongi5.model.User;

 
public interface UserDao {

	User findByName(String name);
	 
	List<User> findAll();

}
