package com.cognizant.microcredentials.fileclaims;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.microcredentials.fileclaims.request.PremiumRequest;
import com.cognizant.microcredentials.fileclaims.response.PremiumResponse;


@FeignClient (name ="PremiumService", url = "http://localhost:9087")
public interface PremiumServiceProxy {
	
	@PostMapping(value = "/getUserPremiumDetails", consumes = "application/json")
	public ResponseEntity<PremiumResponse> getUserPremiumDetails(@Valid @RequestBody PremiumRequest request);

}
