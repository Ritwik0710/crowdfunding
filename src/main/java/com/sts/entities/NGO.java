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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class NGO extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String contact;
	@Column(unique=true)
	private String username;
	@Column(length = 500)
	private String description;
	private String acc_no;
	private String ifsc ;
	private String cert_url;
	public String getCert_url() {
		return cert_url;
	}


	public void setCert_url(String cert_url) {
		this.cert_url = cert_url;
	}



	private String password;
	private String role = "ROLE_USER";
	private boolean enable = false;
	

	public boolean isEnable() {
		return enable;
	}


	public void setEnable(boolean enable) {
		this.enable = enable;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}





	


	public NGO(Integer id, String name, String contact, String username, String description, String acc_no, String ifsc,
			String cert_url, String password, String role, boolean enable, List<Donation> donator, Admin admin) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.username = username;
		this.description = description;
		this.acc_no = acc_no;
		this.ifsc = ifsc;
		this.cert_url = cert_url;
		this.password = password;
		this.role = role;
		this.enable = enable;
		this.donator = donator;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public NGO() {
		super();
	}
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
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



	public List<Donation> getDonator() {
		return donator;
	}



	public void setDonator(List<Donation> donator) {
		this.donator = donator;
	}

	
		
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Donation> donator = new ArrayList<>();

	
}
