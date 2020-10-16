package com.cognizant.microcredentials.premium.controller;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cognizant.microcredentials.premium.PremiumApplicationTests;
import com.cognizant.microcredentials.premium.request.PremiumRequest;

public class ServiceControllerTest extends PremiumApplicationTests{
	
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getUserPremiumDetailsTest() throws Exception {
		   String uri = "/getUserPremiumDetails";
		   PremiumRequest premium = new PremiumRequest();
		   Date dob = Date.valueOf("1991-05-25");
		   premium.setUserId("PL001");
		   premium.setSsn("8978908911");
		   String inputJson = super.mapToJson(premium);
		   MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
				   .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		   int result = mvcResult.getResponse().getStatus();
		   assertEquals(202, result);
		   String content = mvcResult.getResponse().getContentAsString();
		   assertEquals(true, content.contains("userId"));
		}
	
	
	@Test
	public void getUserPremiumDetailsTestSuccess() throws Exception {
		   String uri = "/getUserPremiumDetails";
		   PremiumRequest premium = new PremiumRequest();
		   Date dob = Date.valueOf("1991-05-30");
		   premium.setUserId("PL001");
		   premium.setSsn("8978908911");
		   String inputJson = super.mapToJson(premium);
		   MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
				   .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		   int result = mvcResult.getResponse().getStatus();
		   assertEquals(202, result);
		   String content = mvcResult.getResponse().getContentAsString();
		   assertEquals(true, content.contains("error"));
		   

		   
		}
	


}
