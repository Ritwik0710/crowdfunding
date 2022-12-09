package com.sts.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sts.dao.AdminRepository;
import com.sts.dao.NgoRepository;
import com.sts.dao.UserRepository;
import com.sts.entities.Admin;
import com.sts.entities.Donation;
import com.sts.entities.NGO;
import com.sts.entities.User;
import com.sts.services.NgoServices;

import net.bytebuddy.implementation.ToStringMethod;

@Service
public class NgoservicesImpl implements NgoServices{
	
	@Autowired
	private UserRepository userdao;
	
	@Autowired
	private NgoRepository ngodao;

	@Override
	public NGO register (NGO ngo) throws Exception{
		NGO n= null;
		n=ngodao.getNgoByUsername(ngo.getUsername());
		if(n!=null) {
			System.out.println("You are already registered");
			throw new Exception("Email already in use");
		}
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		ngo.setPassword(encoder.encode(ngo.getPassword()));
		userdao.save(ngo);
//		System.out.println(ngo.getPassword());
		return ngo;
	}

//	@Override
//	public boolean login(String ngo_email, String ngo_password) {
		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public List<Donation> view_donations(String username) {
		return ngodao.getNgoByUsername(username).getDonator();
	}

@Override
public String TotalDonation(NGO ngo) {
	Integer sum=0;
	List<Donation> dlist = ngo.getDonator();
	for(int i=0;i<dlist.size();i++) {
		sum = sum +Integer.parseInt(dlist.get(i).getAmount());
	}
	
	return sum.toString();
}

}
