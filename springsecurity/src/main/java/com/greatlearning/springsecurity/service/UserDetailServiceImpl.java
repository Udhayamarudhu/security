package com.greatlearning.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.springsecurity.dao.UserRepository;
import com.greatlearning.springsecurity.entity.User;
import com.greatlearning.springsecurity.security.MyUserDetails;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByName(username);
		if(user==null) {
			throw new UsernameNotFoundException(username+"not found");
		}
		MyUserDetails userDetails =new MyUserDetails(user);
		
		return userDetails;
	}
}

