package com.sts.userservices;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sts.dao.UserRepository;
import com.sts.entities.User;


public class UserDetailsServicesImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userdao; 

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user =null;
		user = userdao.getUserByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Could not find user!");
		
		}
		UserDetailsImpl userDetailImpl = new UserDetailsImpl(user);
		
		return userDetailImpl;
	}

}
