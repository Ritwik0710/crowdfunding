package com.sts.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sts.entities.Donation;

public interface DonationRepository extends JpaRepository<Donation, Integer> {

}
