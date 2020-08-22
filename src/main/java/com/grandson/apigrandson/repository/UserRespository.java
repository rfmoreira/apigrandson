package com.grandson.apigrandson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grandson.apigrandson.models.User;

public interface UserRespository extends JpaRepository<User, Long>{

	User findById(long id);
	
	
}
