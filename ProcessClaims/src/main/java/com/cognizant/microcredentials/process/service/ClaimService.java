package com.cognizant.microcredentials.process.service;

import com.cognizant.microcredentials.process.request.ClaimRequest;
import com.cognizant.microcredentials.process.response.ClaimResponse;

public interface ClaimService {
	
	public ClaimResponse fileClaims(ClaimRequest request);

}
