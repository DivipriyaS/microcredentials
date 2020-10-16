package com.cognizant.microcredentials.process.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cognizant.microcredentials.process.dao.ClaimsDao;
import com.cognizant.microcredentials.process.entity.Claims;
import com.cognizant.microcredentials.process.service.EmailService;
import com.cognizant.microcredentials.process.util.Constant;

@Component
public class ProcessServiceController {
	private static final Logger logger = LoggerFactory.getLogger(ProcessServiceController.class);

	@Autowired
	ClaimsDao claimsDao;
	@Autowired
	EmailService service;

	@Scheduled(cron = "1 * * * * ?")
	public void processClaims() {
		
		
		Optional<List<Claims>> claims = claimsDao.findByClaimsStatus("Submitted");
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		if (claims.isPresent()) {
			claims.get().forEach(claim -> {
				if (claim.getClaimAmount() <= claim.getClaimPolicy().getTotalAmount()) {
					claim.setClaimsStatus("Processed");
					claim.setProcessComments("Bill Processed for " + claim.getClaimPolicy().getPolicyNumber());
					claim.setProcessDate(date);
					claim.getClaimPolicy()
							.setTotalAmount(claim.getClaimPolicy().getTotalAmount() - claim.getClaimAmount());
					claimsDao.save(claim);
					service.sendEmail(claim.getClaimPolicy().getUser().getEmailAddress(), Constant.EMAIl_SUCCESS_TEXT);
					logger.debug("Claim Processed Successfully");
				} else {
					
					  claim.setClaimsStatus("Failed");
					  claim.setProcessComments("Bill Process failed for " +
					  claim.getClaimPolicy().getPolicyNumber() +
					  "Calim amount is more than policy amount"); claim.setProcessDate(date);
					  claimsDao.save(claim);
					 
					service.sendEmail(claim.getClaimPolicy().getUser().getEmailAddress(), Constant.EMAIl_FAILED_TEXT);
					logger.debug("Process Claim failed for " + claim.getClaimId());
				}
			});
		}

	}

}
