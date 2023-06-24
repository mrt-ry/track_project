package com.example.demo.domain.User;

import java.util.Collections;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService{

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		Userdata user = userRepository.findByUserName(userName);
		return new User(user.getUserName(), user.getPassword(), Collections.emptyList());
	}

	public void createUser(String name,String password){
		userRepository.createUser(name,password);
	}
}
