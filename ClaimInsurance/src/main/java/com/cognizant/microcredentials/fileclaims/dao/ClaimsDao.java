package com.cognizant.microcredentials.fileclaims.dao;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.microcredentials.fileclaims.entity.Claims;

public interface ClaimsDao extends CrudRepository<Claims, Long> {
	
}
