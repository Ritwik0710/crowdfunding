package com.sts.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sts.entities.Donation;
import com.sts.entities.NGO;

@Service
public interface NgoServices {
	
	public NGO register(NGO ngo) throws Exception;
	
//	public boolean login(String ngo_email,String ngo_password);
	
	public List<Donation> view_donations(String email);
	
	public String TotalDonation(NGO ngo);

}
