package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.User;

public interface UserDAO {
	
	public User get(String id);
	
	public List<User> list();
	
	//If you are not using spring security, you need to define validate function
	public boolean isValidCredentials(String id, String password);
	
	public boolean save(User user);
	
	public boolean update(User user);

}
