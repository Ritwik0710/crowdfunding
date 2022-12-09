package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.dao.NgoRepository;
import com.sts.entities.Admin;
import com.sts.entities.NGO;
import com.sts.services.AdminServices;
import com.sts.servicesimpl.AdminServicesImpl;

@RestController
@RequestMapping(path="/admin")
@CrossOrigin("*")
public class AdminServicesController {
	@Autowired
	AdminServices adminservices;
	
	@Autowired
	NgoRepository ngodao;
	
	@PutMapping("/validate/{ngo_id}")
	public NGO validate(@PathVariable("ngo_id") Integer ngo_id) {
//		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return this.adminservices.validate(ngodao.getNgoById(ngo_id));
	}
	
	@PostMapping("/first")
	public Admin adminEntry() {
		return this.adminservices.adminEntry();
	}
	
	@GetMapping("/dashboard")
	public List<NGO> adminViewNgo(){
		return this.adminservices.adminViewNgo();
	}

}
