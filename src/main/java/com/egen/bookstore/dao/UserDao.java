package com.egen.bookstore.dao;

import java.util.List;

import com.egen.bookstore.model.User;

public interface UserDao {

	public User createUser(User user);
	
	public User updateUser(User user);
	
	public User getUser(Long id);
	
	public List<User> getAllUsers();
}
