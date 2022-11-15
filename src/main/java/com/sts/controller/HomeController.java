package com.sts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sts.dao.NgoRepository;
import com.sts.entities.NGO;

@Controller
public class HomeController {
	@Autowired
	private NgoRepository ngoRepository;
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		
		NGO ngo = new NGO();
		ngo.setName("NGO1");
		ngo.setEmail("abcdgmcom");
		
		ngoRepository.save(ngo);
		
		return "Working";
	}

}
