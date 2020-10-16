package com.cognizant.microcredentials.premium.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.microcredentials.premium.dao.PolicyDao;
import com.cognizant.microcredentials.premium.exception.InvalidUserException;
import com.cognizant.microcredentials.premium.exception.PremiumNotFoundException;
import com.cognizant.microcredentials.premium.exception.ServiceException;
import com.cognizant.microcredentials.premium.request.PremiumRequest;
import com.cognizant.microcredentials.premium.request.TransactionRequest;
import com.cognizant.microcredentials.premium.response.ErrorResponse;
import com.cognizant.microcredentials.premium.response.PremiumResponse;
import com.cognizant.microcredentials.premium.response.TransactionResponse;
import com.cognizant.microcredentials.premium.service.PremiumService;
import com.cognizant.microcredentials.premium.PremiumConstants;

@RestController
public class ServiceController {

	@Autowired
	PremiumService premiumService;

	@Autowired
	PolicyDao policydao;

	@PostMapping(value = "/getUserPremiumDetails", consumes = "application/json")
	public ResponseEntity<PremiumResponse> getUserPremiumDetails(@Valid @RequestBody PremiumRequest request) {

		ErrorResponse errorResponse = null;
		PremiumResponse premiumResponse = null;
		try {
			try {
				premiumResponse = premiumService.findUserPremiumDetails(request);
				premiumResponse.setStatus(PremiumConstants.SUCCESS);
			} catch (InvalidUserException e) {
				errorResponse = new ErrorResponse();
				errorResponse.setCode(PremiumConstants.INVALID_USER);
				errorResponse.setMessage(e.getMessage());
				throw new ServiceException(errorResponse);
			} catch (PremiumNotFoundException e) {
				errorResponse = new ErrorResponse();
				errorResponse.setCode(PremiumConstants.NOT_FOUND_PREMIUM);
				errorResponse.setMessage(e.getMessage());
				throw new ServiceException(errorResponse);
			}
		} catch (ServiceException e) {
			premiumResponse = new PremiumResponse();
			premiumResponse.setError(e.getError());
			return ResponseEntity.accepted().body(premiumResponse);
		}

		return ResponseEntity.accepted().body(premiumResponse);
	}

	@PostMapping(value = "/savePaymentDetails", consumes = "application/json")
	public ResponseEntity<Object> savePaymentDetails(@Valid @RequestBody TransactionRequest request) {

		ErrorResponse errorResponse = null;
		TransactionResponse transactionResponse = new TransactionResponse();
		try {
			try {
				transactionResponse = premiumService.saveTrancationDetails(request);
			}  catch (PremiumNotFoundException e) {
				errorResponse = new ErrorResponse();
				errorResponse.setCode(PremiumConstants.NOT_FOUND_PREMIUM);
				errorResponse.setMessage(e.getMessage());
				throw new ServiceException(errorResponse);
			}
		} catch (ServiceException e) {
			return ResponseEntity.accepted().body(errorResponse);
		}

		return ResponseEntity.accepted().body(transactionResponse);
	}

}
