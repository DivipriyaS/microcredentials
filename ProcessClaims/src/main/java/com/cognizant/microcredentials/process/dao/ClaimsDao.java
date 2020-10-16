package com.cognizant.microcredentials.process.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.microcredentials.process.entity.Claims;

public interface ClaimsDao extends CrudRepository<Claims, Long> {
	
	public Optional<List<Claims>> findByClaimsStatus(String status);
	
}
