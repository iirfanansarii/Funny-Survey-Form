package com.irfan.SpringBootWithJpa.dao;

// this is interface class

import com.irfan.SpringBootWithJpa.Modals.User;

public interface UserDao {

	 public User registerUser(User u) ;
	 
	 public User loginUser(User u);
	 
	
	 
	
}
