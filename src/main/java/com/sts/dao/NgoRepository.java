package com.sts.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sts.entities.NGO;

public interface NgoRepository extends JpaRepository<NGO, Integer> {
	
	@Query(value = "SELECT * FROM user  WHERE id = ?1", nativeQuery = true)
	NGO getNgoById(Integer ngo_id);
	
	@Query(value = "SELECT * FROM user  WHERE username = ?1", nativeQuery = true)
	NGO getNgoByUsername(String ngo_username);
	
	@Query(value = "SELECT * FROM user WHERE enable = ?1 AND role = 'ROLE_USER'", nativeQuery = true)
	List<NGO> getNgoByEnable(boolean ngo_enable);

} 
