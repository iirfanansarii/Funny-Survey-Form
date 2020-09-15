package com.irfan.SpringBootWithJpa.Modals;

// this is java modal class to create entity in data base

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//modal for database

@Entity(name="users")
@Table(name="users")

public class User {
	
	@Id                                             // primary key
	@Column(name="user_id")                           // attribute name in database
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // for auto incremented user id 
	
	private Long id;
	
	@Column(name="user_name")   // method to create column in table
	private String name;        // defining variable 
	
	
   @Column(name="user_email")
	private String email ;
	
	@Column(name="user_password")
	private String password;

	
 @Temporal(TemporalType.TIMESTAMP)
 @Column(name="user_regDate")
	private Date regDate;


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public Date getRegDate() {
	return regDate;
}


public void setRegDate(Date regDate) {
	this.regDate = regDate;
}


@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", regDate=" + regDate
			+ "]";
}
 
	


	
}
