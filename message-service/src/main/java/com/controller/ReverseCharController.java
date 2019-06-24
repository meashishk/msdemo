package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.RequestStringModel;

@RestController
public class ReverseCharController {
	
	@RequestMapping(value = "/reverse", method = RequestMethod.POST)
	@ResponseBody
	public RequestStringModel reverseCall(@RequestBody RequestStringModel message) {
		
		System.out.println("******************Reverse MS2************************");
		String strReceived = message.getMessage();
		System.out.println("Received String:"+message.getMessage());
		
		byte[] strByteArray = strReceived.getBytes();
		byte[] stringReversed = new byte[strByteArray.length];
		
		// reverse the string received
		for(int i=0; i<strByteArray.length; i++) {
			stringReversed[i] = strByteArray[strByteArray.length-i-1];
		}
		
		message.setMessage(new String(stringReversed));
		System.out.println("Reversed String:"+new String(stringReversed));
		
		return message;
	}

}
