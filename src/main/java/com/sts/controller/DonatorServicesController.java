package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entities.Donation;
import com.sts.entities.NGO;
import com.sts.services.DonatorServices;

@RestController
@RequestMapping(path ="/crowdfund")
@CrossOrigin("*")
public class DonatorServicesController {
	
	@Autowired
	private DonatorServices donatorservices;
	
	@GetMapping("/browse")
	public List<NGO> browse(){
		return this.donatorservices.browse();
	
}
	@GetMapping("/view_ngo/{ngo_id}")
	public NGO view_ngo(@PathVariable("ngo_id") Integer ngo_id) {
		return this.donatorservices.view_ngo(ngo_id);
	}
	
	@PostMapping("/donate/{ngo_id}")
	public Donation donate(@RequestBody Donation don,@PathVariable("ngo_id") Integer ngo_id) {
		return this.donatorservices.donate(don,ngo_id);
	}

}
