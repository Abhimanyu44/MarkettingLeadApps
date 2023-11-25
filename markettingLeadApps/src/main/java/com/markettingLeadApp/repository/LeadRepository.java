package com.markettingLeadApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markettingLeadApp.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {
	

	
}