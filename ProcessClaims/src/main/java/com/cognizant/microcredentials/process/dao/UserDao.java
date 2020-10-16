package com.cognizant.microcredentials.process.dao;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.microcredentials.process.entity.User;

public interface UserDao extends CrudRepository<User, String>{
	
	public User findByUsrId(String usrId);
	

}
