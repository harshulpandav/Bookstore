package com.egen.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.egen.bookstore.model.User;
import com.egen.bookstore.model.ValidationError;

@Service
public interface UserService {

	public User createUser(User user);
	
	public User updateUser(User user);
	
	public ValidationError validateUser(User user);
	
	public List<User> getAllUsers();
}
