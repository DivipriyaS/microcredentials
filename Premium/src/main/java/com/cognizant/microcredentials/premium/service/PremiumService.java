package com.cognizant.microcredentials.premium.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.microcredentials.premium.dao.PolicyDao;
import com.cognizant.microcredentials.premium.dao.TransactionDao;
import com.cognizant.microcredentials.premium.dao.UserDao;
import com.cognizant.microcredentials.premium.entity.Policy;
import com.cognizant.microcredentials.premium.entity.Transaction;
import com.cognizant.microcredentials.premium.entity.User;
import com.cognizant.microcredentials.premium.exception.InvalidUserException;
import com.cognizant.microcredentials.premium.exception.PremiumNotFoundException;
import com.cognizant.microcredentials.premium.request.PremiumRequest;
import com.cognizant.microcredentials.premium.request.TransactionRequest;
import com.cognizant.microcredentials.premium.response.PremiumResponse;
import com.cognizant.microcredentials.premium.response.TransactionResponse;
import com.cognizant.microcredentials.premium.response.UserPolicyVO;
import com.cognizant.microcredentials.premium.util.BusinessUtil;

@Service
public class PremiumService {

	@Autowired
	UserDao userDao;
	@Autowired
	PolicyDao policyDao;
	@Autowired
	TransactionDao transactionDao;

	public PremiumResponse findUserPremiumDetails(PremiumRequest request)
			throws InvalidUserException, PremiumNotFoundException {
		Optional<User> user = null;
		PremiumResponse response = null;

		user = userDao.findByUsrId(request.getUserId());

		if (user != null) {
			boolean validUser = BusinessUtil.validateUser(user, request);
			if (validUser) {
				List<UserPolicyVO> userPolicy = new ArrayList<UserPolicyVO>();
				Set<Policy> iterator = user.get().getPolicies();
				iterator.forEach(policy -> {
					userPolicy.add(new UserPolicyVO(policy));
				});
				if (userPolicy.isEmpty()) {
					throw new PremiumNotFoundException("Policy not found for the user");
				}
				response = new PremiumResponse(user.get());
				response.setUserPolicy(userPolicy);
			} else {
				throw new InvalidUserException("Invalid User details");
			}
		} else {
			throw new InvalidUserException("Invalid User details");
		}

		return response;

	}

	public TransactionResponse saveTrancationDetails(TransactionRequest request) throws PremiumNotFoundException {

		Optional<User> user = null;
		Policy policy = null;
		TransactionResponse response = null;
		boolean policyFound = false;
		user = userDao.findByUsrId(request.getUserId());
		if (user == null) {
			throw new PremiumNotFoundException("Invalid user details");
		}
		Iterator<Policy> iterator = user.get().getPolicies().iterator();
		while (iterator.hasNext()) {
			policy = iterator.next();
			if (policy.getPolicyNumber() == Long.valueOf(request.getPolicyNumber())) {
				policyFound = true;
				if (request.getTransactionAmount() == policy.getDueAmount()) {
					try {
						Transaction transaction = transactionDao.save(new Transaction(policy, request));
						response = new TransactionResponse();
						response.setStatus("Success");
						response.setMessage("Transaction Success for policy " + policy.getPolicyNumber());
						return response;
					} catch (Exception e) {
						response = new TransactionResponse();
						response.setStatus("Failed");
						response.setMessage("Transaction Failed for policy " + policy.getPolicyNumber());
						return response;
					}
				} else {
					response = new TransactionResponse();
					response.setStatus("Failed");
					response.setMessage("Transaction Failed for policy " + policy.getPolicyNumber() + " due to incorrect due amount");
					return response;
				}

			}
		}

		if (!policyFound) {
			throw new PremiumNotFoundException("Invalid user details");
		}

		return response;
	}
}
