package com.cognizant.microcredentials.fileclaims.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cognizant.microcredentials.fileclaims.dao.ClaimsDao;
import com.cognizant.microcredentials.fileclaims.dao.PolicyDao;
import com.cognizant.microcredentials.fileclaims.entity.Claims;
import com.cognizant.microcredentials.fileclaims.entity.Policy;
import com.cognizant.microcredentials.fileclaims.exception.InvalidClaimException;
import com.cognizant.microcredentials.fileclaims.request.ClaimRequest;
import com.cognizant.microcredentials.fileclaims.response.ClaimResponse;
import com.cognizant.microcredentials.fileclaims.response.PremiumResponse;
import com.cognizant.microcredentials.fileclaims.response.UserPolicyVO;

@Service
public class ClaimsService {

	@Autowired
	PolicyDao policyDao;
	@Autowired
	ClaimsDao claimsDao;
	
	@Autowired
	EntityManagerFactory entityManager;

	public ClaimResponse fileClaims(PremiumResponse response, ClaimRequest request) throws InvalidClaimException {
		ClaimResponse claimResponse = new ClaimResponse();
		Policy policy = null;
		String policyNumber = request.getPolicyNumber();

		Iterator<UserPolicyVO> iterator = response.getUserPolicy().iterator();

		while (iterator.hasNext()) {
			String userPolicy = iterator.next().getPolicyNumber();
			if (null != policyNumber && policyNumber.equals(userPolicy)) {
				policy = policyDao.findByPolicyNumber(Long.valueOf(policyNumber));
			}

		}
		if (null != policy) {
			claimsDao.save(new Claims(policy, request));
			claimResponse.setStatus("Success");
			claimResponse.setMessage("Your claim submitted successfully");
		} else {
			throw new InvalidClaimException("Invalid Claim Details");
		}

		return claimResponse;
	}
	
	public ClaimResponse fileClaimsV2(PremiumResponse response, ClaimRequest request, MultipartFile file) throws InvalidClaimException, IOException {
		ClaimResponse claimResponse = new ClaimResponse();
		Policy policy = null;
		String policyNumber = request.getPolicyNumber();
		InputStream inputStream = file.getInputStream();
	    EntityManager em = entityManager.createEntityManager();
	    Session session = (Session) em.getDelegate();
	    Blob blobFile = Hibernate.getLobCreator(session).createBlob(inputStream, file.getSize());
		
		Iterator<UserPolicyVO> iterator = response.getUserPolicy().iterator();

		while (iterator.hasNext()) {
			String userPolicy = iterator.next().getPolicyNumber();
			if (null != policyNumber && policyNumber.equals(userPolicy)) {
				policy = policyDao.findByPolicyNumber(Long.valueOf(policyNumber));
			}

		}
		if (null != policy) {
			claimsDao.save(new Claims(policy, request, blobFile));
			claimResponse.setStatus("Success");
			claimResponse.setMessage("Your claim submitted successfully");
		} else {
			throw new InvalidClaimException("Invalid Claim Details");
		}

		return claimResponse;
	}

}
