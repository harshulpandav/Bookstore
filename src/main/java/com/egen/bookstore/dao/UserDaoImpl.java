package com.egen.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egen.bookstore.model.User;
 
/**
 * DAO implementation for User entity
 *  
 */
@Repository

public class UserDaoImpl implements UserDao{
 
    @PersistenceContext
    private EntityManager em;
     
    @Transactional
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
    	em.persist(user);
		return user;
	}

    @Transactional
	@Override
	public User updateUser(User user) {
    	em.merge(user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		 return em.createQuery("SELECT u FROM User u", User.class).getResultList();
	}

	@Override
	public User getUser(Long id) {
		User user = em.find(User.class, id);
		return user;
	}


}
