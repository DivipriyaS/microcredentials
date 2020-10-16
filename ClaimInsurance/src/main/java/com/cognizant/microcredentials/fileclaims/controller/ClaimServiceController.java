package com.cognizant.microcredentials.fileclaims.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cognizant.microcredentials.fileclaims.PremiumServiceProxy;
import com.cognizant.microcredentials.fileclaims.exception.InvalidClaimException;
import com.cognizant.microcredentials.fileclaims.request.ClaimRequest;
import com.cognizant.microcredentials.fileclaims.request.PremiumRequest;
import com.cognizant.microcredentials.fileclaims.response.ClaimResponse;
import com.cognizant.microcredentials.fileclaims.response.PremiumResponse;
import com.cognizant.microcredentials.fileclaims.service.ClaimsService;
import com.google.gson.Gson;

@RestController
public class ClaimServiceController {

	@Autowired
	ClaimsService claimsService;

	@Autowired
	PremiumServiceProxy premiumServiceProxy;

	@PostMapping(value = "/v1/fileClaims", consumes = "application/json")
	public ResponseEntity<ClaimResponse> fileClaims(@Valid @RequestBody ClaimRequest request) {
		ClaimResponse response = new ClaimResponse();
		PremiumResponse premiumResponse = null;
		PremiumRequest premiumRequest = new PremiumRequest(request);

		premiumResponse = premiumServiceProxy.getUserPremiumDetails(premiumRequest).getBody();
		if (null != premiumResponse && !premiumResponse.getUserPolicy().isEmpty()) {

			try {
				response = claimsService.fileClaims(premiumResponse, request);
			} catch (InvalidClaimException e) {
				response.setStatus("Failed");
				response.setMessage("Invalid Claim Details");
			}
		}

		return ResponseEntity.accepted().body(response);

	}
	
	
	@PostMapping(value = "/v2/fileClaims", consumes = "multipart/form-data")
	public ResponseEntity<ClaimResponse> fileClaimsV2(@RequestParam("upload") MultipartFile file, @RequestParam("jsonRequest") String fileRequest) throws IOException {
		ClaimResponse response = new ClaimResponse();
		Gson jsonPrasing = new Gson();
		ClaimRequest request = jsonPrasing.fromJson(fileRequest, ClaimRequest.class);
		PremiumResponse premiumResponse = null;
		PremiumRequest premiumRequest = new PremiumRequest(request);

		premiumResponse = premiumServiceProxy.getUserPremiumDetails(premiumRequest).getBody();
		if (null != premiumResponse && !premiumResponse.getUserPolicy().isEmpty()) {

			try {
				response = claimsService.fileClaimsV2(premiumResponse, request, file);
			} catch (InvalidClaimException e) {
				response.setStatus("Failed");
				response.setMessage("Invalid Claim Details");
			}
		}

		return ResponseEntity.accepted().body(response);

	}
}
