package com.sts.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.DonationRepository;
import com.sts.dao.NgoRepository;
import com.sts.dao.UserRepository;
import com.sts.entities.Donation;
import com.sts.entities.NGO;
import com.sts.services.DonatorServices;

@Service
public class DonatorServicesImpl implements DonatorServices {
	
	@Autowired
	private NgoRepository ngodao;
	
	@Autowired
	private UserRepository userdao;
	
	@Autowired
	private DonationRepository donationdao;
	
	@Override
	public List<NGO> browse() {
		return ngodao.getNgoByEnable(true);
	}

	@Override
	public NGO view_ngo(Integer ngo_id) {
		return ngodao.getNgoById(ngo_id);
	}

	@Override
	public Donation donate(Donation don,Integer ngo_id) {
//		NGO ngo = ngodao.getNgoById(ngo_id);
//		
//		don.setNgo(ngo);
//		
//		ngo.getDonator().add(don);
//		ngodao.save(ngo);
//		don.setAmount(null);
//	    donationdao.save(don);
//	    return don;
		NGO ngo=ngodao.getNgoById(ngo_id);
		don.setNgo(ngo);
		ngo.getDonator().add(don);
		ngodao.save(ngo);
		
		return don;
	}

}
