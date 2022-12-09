package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entities.Donation;
import com.sts.entities.NGO;
import com.sts.services.NgoServices;

@RestController
@RequestMapping(path = "/nngo")
@CrossOrigin("*")
public class NgoServicesController {
	
	@Autowired
	private NgoServices ngoservices;
	
	@PostMapping("/register")
	public NGO register (@RequestBody NGO ngo) throws Exception{
		return this.ngoservices.register(ngo);
	}
	 
//	public boolean login(String ngo_email,String ngo_password) {
//		
//	}
	
	@GetMapping("ngo/view_donation")
	public List<Donation> view_donations()
	{
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return this.ngoservices.view_donations(userDetails.getUsername());
	}
}
