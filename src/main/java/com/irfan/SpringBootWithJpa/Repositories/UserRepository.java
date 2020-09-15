package com.irfan.SpringBootWithJpa.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irfan.SpringBootWithJpa.Modals.User;

// this is class of interface type 

// here User is modal class name and Long is User Id type

public interface UserRepository extends JpaRepository<User, Long>{

		User findByEmailAndPassword(String email, String password);
		// user = select * from user where email=e and password=pass;
		
		
}
