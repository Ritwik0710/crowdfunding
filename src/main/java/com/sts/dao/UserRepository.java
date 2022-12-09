package com.sts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sts.entities.Admin;
import com.sts.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery = true)
	User getUserByUsername(String User_username);

}
