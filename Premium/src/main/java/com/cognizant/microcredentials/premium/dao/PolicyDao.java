package com.cognizant.microcredentials.premium.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.microcredentials.premium.entity.Policy;
import com.cognizant.microcredentials.premium.entity.User;

@Repository
public interface PolicyDao extends CrudRepository<Policy, Long> {

	public Policy findByPolicyId(int policyId);
	public List<Policy> findByUser(User user);
}
