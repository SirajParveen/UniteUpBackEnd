package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.User;

public interface UserDAO {

	public boolean saveOrUpdate(User User);

	public boolean delete(User User);

	public List<User> list();

	public List<User> getuser(int id);

	public User oneuser(int id);

	public User authuser(String username, String password);

	public User profileof(String username);

	public List<User> nonfriends(int id);

}
