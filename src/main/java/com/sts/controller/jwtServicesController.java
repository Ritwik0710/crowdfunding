package com.sts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sts.securityconfig.JwtRequest;
import com.sts.securityconfig.JwtResponse;
import com.sts.securityconfig.JwtUtils;
import com.sts.userservices.UserDetailsServicesImpl;

@RestController
public class jwtServicesController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServicesImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	///genenrate token
	@PostMapping("/ngologin")
	public String generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		String token;
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
//			authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
			token = "success";
//			UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		}catch(UsernameNotFoundException e){
//			e.printStackTrace();
			token = "failed";
//			throw new Exception("User not found");
		}
		
//		String token = this.jwtUtils.generateToken(userDetails);
//		return ResponseEntity.ok(new JwtResponse(token));
		return token;
	}
	
	
	
//	private void authenticate(String username ,String password) throws Exception {
//		 try {
//			 authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//		 }catch(DisabledException e)
//		 {
////			 throw new Exception("USER DISABLED"+e.getMessage());
//		 }catch(BadCredentialsException e) {
////			 throw new Exception("Invalid Credentials" + e.getMessage());
//		 }
//	}

}
