package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestStringModel {
	
	@JsonProperty
	private String message;
	
	public RequestStringModel() {}
	
	public RequestStringModel(String message) {
        super();
        this.message = message;
    }

	 public String getMessage() {
	        return message;
	 }
	 
	 public void setMessage(String message) {
			this.message = message;
	}
	 
	 
	@Override
    public String toString() {
        return " "+message+ " ";
    }

	
}
