package com.egen.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.bookstore.dao.UserDao;
import com.egen.bookstore.model.User;
import com.egen.bookstore.model.ValidationError;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public User createUser(User user) {
		user = userDao.createUser(user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public ValidationError validateUser(User user) {
		ValidationError v = new ValidationError();
		if(user.getFirstName()==null || "".equals(user.getFirstName())){
			v.addFieldError("firstName", "First Name cannot be empty or null");
		}
		if(user.getLastName()==null || "".equals(user.getFirstName())){
			v.addFieldError("lastName", "Last Name cannot be empty or null");
		}
		if(user.getAge()==null || user.getAge()<=0){
			v.addFieldError("age", "Age should be a valid non zero positive number");
		}
		if(user.getGender() == null || (!"M".equals(user.getGender()) && !"F".equals(user.getGender()))){
			v.addFieldError("gender", "Gender should be M or F");
		}
		if(user.getPhone()!=null && (String.valueOf(user.getPhone()).length()!=10 || user.getPhone()<0)){
			v.addFieldError("phone", "Phone should be 10 digit positive number");
		}
		// TODO Auto-generated method stub
		return v;
	}


}
