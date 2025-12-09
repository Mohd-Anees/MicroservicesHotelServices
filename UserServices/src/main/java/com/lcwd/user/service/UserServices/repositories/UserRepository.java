package com.lcwd.user.service.UserServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.service.UserServices.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
//we can write custom query and anythings here
	//if we want to implement any custom method
	
}
