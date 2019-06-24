package com.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.model.RequestStringModel;

@RestController
public class RequestProcessController {
	
	@RequestMapping(value = "/api", method = RequestMethod.POST)
	@ResponseBody
	public RequestStringModel apiCall(@RequestBody String bodyJson) {
		System.out.println("******************MS1 Receive Request************************");
		
		// URL for reverse microservice..
		// we can place this in .properties as well
		final String uri = "http://localhost:8081/reverse/";
		
	    RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<String> composeRequest = new HttpEntity<String>(bodyJson, headers);
	    
	    RequestStringModel recReversedStrModel = restTemplate.postForObject(uri, composeRequest, RequestStringModel.class); 
	    System.out.println("Received String from MS2:"+recReversedStrModel.getMessage());
	    
	    // random generator
	    double randomNum = Math.random();
	    recReversedStrModel.setRandomNum(randomNum);
		
		return recReversedStrModel;
	}

}
