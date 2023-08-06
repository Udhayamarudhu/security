package com.greatlearning.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.springsecurity.entity.User;


public interface UserRepository extends JpaRepository<User,Integer>{
	 User findByName(String name);

}
