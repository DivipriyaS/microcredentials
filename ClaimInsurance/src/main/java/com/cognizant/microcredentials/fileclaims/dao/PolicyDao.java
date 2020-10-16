package com.cognizant.microcredentials.fileclaims.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.microcredentials.fileclaims.entity.Policy;
import com.cognizant.microcredentials.fileclaims.entity.User;

@Repository
public interface PolicyDao extends CrudRepository<Policy, Long> {

	public Policy findByPolicyId(int policyId);
	public List<Policy> findByUser(User user);
	public Policy findByPolicyNumber(long policyNumber);
}
