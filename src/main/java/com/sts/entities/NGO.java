package com.sts.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="ngo")
public class NGO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String location;
	private String contact;
	private String email;
	private String cert_url;
	@Column(length = 500)
	private String description;
	private String acc_no;
	private String ifsc ;
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	
	



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCert_url() {
		return cert_url;
	}



	public void setCert_url(String cert_url) {
		this.cert_url = cert_url;
	}


	
	public String getAcc_no() {
		return acc_no;
	}



	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}



	public String getIfsc() {
		return ifsc;
	}



	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}



	public List<Donator> getDonator() {
		return donator;
	}



	public void setDonator(List<Donator> donator) {
		this.donator = donator;
	}

	
		
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "ngo")
	private List<Donator> donator = new ArrayList<>();


	
}
