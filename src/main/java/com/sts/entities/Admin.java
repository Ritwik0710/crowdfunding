package com.sts.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Admin extends User{
	
	@Id
	private Integer id = 0;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	private String username= "admin";
	
	private String password ="admin";
	
	private String role = "ROLE_ADMIN";
	
	private boolean enable = true ;
	
	
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public Admin(Integer id, String username, String password, String role, boolean enable, List<NGO> ngo_status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.enable = enable;
	}
	
	public Admin() {
		super();
	}
}
