package com.sts.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sts.dao.AdminRepository;
import com.sts.dao.NgoRepository;
import com.sts.dao.UserRepository;
import com.sts.entities.Admin;
import com.sts.entities.NGO;
import com.sts.services.AdminServices;

@Service
public class AdminServicesImpl implements AdminServices{
	
	@Autowired
	private AdminRepository admindao;
	
	@Autowired
	private UserRepository userdao;
	
	@Autowired
	private NgoRepository ngodao;
	
	@Override
	public NGO validate(NGO ngo) {
//		NGO ngo= ngodao.getNgoById(ngo_id);
		if(ngo.isEnable()==false)
			ngo.setEnable(true);
		else
		ngo.setEnable(false);
		ngodao.save(ngo);
		userdao.save(ngo);
		return ngo;
	}

	@Override
	public List<NGO> adminViewNgo() {
		return ngodao.findAll();
	}

	@Override
	public Admin adminEntry() {
		Admin adm = new Admin();
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		adm.setPassword(encoder.encode(adm.getPassword()));
		admindao.save(adm);
		return adm;
	}

	
}
