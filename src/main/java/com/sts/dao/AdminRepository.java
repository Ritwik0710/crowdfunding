package com.sts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sts.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	@Query(value = "SELECT * FROM user  WHERE username = ?1", nativeQuery = true)
	Admin getAdminByUsername(String admin_username);
}
