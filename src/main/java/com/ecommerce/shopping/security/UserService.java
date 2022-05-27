package com.ecommerce.shopping.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.shopping.entity.Users;
import com.ecommerce.shopping.repository.UserRepository;

@Service
public class UserService implements  UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users foundUser = userRepository.findByUserName(userName);
		if(foundUser == null) 
			return null;
		
		String name = foundUser.getUserName();
		String password = foundUser.getPassword();
		String email = foundUser.getEmail();
		String phone = foundUser.getPhone();
		return new User(name, password, new ArrayList<>());
	}
}

