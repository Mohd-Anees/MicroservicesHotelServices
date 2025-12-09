package com.lcwd.user.service.UserServices.services;

import java.util.List;

import com.lcwd.user.service.UserServices.entities.User;

public interface UserService {
	
	//create
	public User saveUser(User user);
	
	//get all user
	public List<User> getAllUser();
	
	//get single user of given userId
	public User getUser(String userId);
	
	//delete single user
	public void deleteUser(String userId);
	
	//update user
	//public User updateUser(User upDateUser,String userId);

	public User updateUser(User user, String userId);
	
	
	
	

}
