package com.cognizant.microcredentials.premium.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.microcredentials.premium.entity.User;

public interface UserDao extends CrudRepository<User, String>{
	
	public Optional<User> findByUsrId(String usrId);
	
	
}
