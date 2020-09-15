package com.irfan.SpringBootWithJpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.irfan.SpringBootWithJpa.Modals.User;
import com.irfan.SpringBootWithJpa.Repositories.UserRepository;

// this is java class

@Repository
public class DaoImplementation implements UserDao  {
	
	
	@Autowired
	public UserRepository userRepo;
	

	@Override
	public User registerUser(User u) {
		  
		return userRepo.save(u);
	}


	@Override
	public User loginUser(User u) {
		User user = userRepo.findByEmailAndPassword(u.getEmail(), u.getPassword());
		if(user == null) {
			return null ;
		}
		return user;
	}


	
	

}
