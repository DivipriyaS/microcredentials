package com.cognizant.microcredentials.fileclaims.dao;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.microcredentials.fileclaims.entity.User;

public interface UserDao extends CrudRepository<User, String>{
	
	public User findByUsrId(String usrId);
	

}
