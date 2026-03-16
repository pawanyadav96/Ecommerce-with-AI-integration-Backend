package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.UserPrinciple;
import com.example.entity.Users;
import com.example.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = userrepo.findByUsername(username);
		
		if(user ==  null)
		{
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("user not found");
		}
		
		
		return new UserPrinciple(user);
	}

}
