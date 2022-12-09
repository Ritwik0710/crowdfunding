package com.sts.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sts.entities.Donation;
import com.sts.entities.NGO;

@Service
public interface DonatorServices {

	public List<NGO> browse();
	
	public NGO view_ngo(Integer ngo_id);
	
	public Donation donate(Donation don,Integer ngo_id);
}
