package com.ecommerce.shopping.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shopping.entity.AuthenticationRequest;
import com.ecommerce.shopping.entity.AuthenticationResponse;
import com.ecommerce.shopping.entity.Users;
import com.ecommerce.shopping.repository.UserRepository;

@RestController
public class AuthController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/signUp")
	private ResponseEntity<?> addClient(@RequestBody AuthenticationRequest authenticationRequest) {
		String userName = authenticationRequest.getUserName();
		String password = authenticationRequest.getPassword();
		String email = authenticationRequest.getEmail();
		String phone = authenticationRequest.getPhone();
		Users user = new Users();
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		try {
			userRepository.save(user);
		}
		catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error during signup"+" "+userName));
		}				
		return ResponseEntity.ok(new AuthenticationResponse("Successfully signedup for the Application"+" "+userName));
	}

	@PostMapping("/auth")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest) {
		String userName = authenticationRequest.getUserName();
		String password = authenticationRequest.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		}
		catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error during Authentication"+" "+userName));
		}
		return ResponseEntity.ok(new AuthenticationResponse("Successfully Authenticated"+" " +userName));
	}
}
