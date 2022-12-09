package com.sts.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sts.entities.Admin;
import com.sts.entities.NGO;

@Service
public interface AdminServices {
	
	public List<NGO> adminViewNgo();

	public NGO validate(NGO ngo);
	
	public Admin adminEntry();
}
