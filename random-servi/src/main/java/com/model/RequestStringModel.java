package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestStringModel {

	@JsonProperty
	private String message;

	@JsonProperty
	private double randomNum;

	public RequestStringModel() {
	}

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

	public double getRandomNum() {
		return randomNum;
	}

	public void setRandomNum(double randomNum) {
		this.randomNum = randomNum;
	}

	@Override
	public String toString() {
		return " " + message + " " + randomNum + " ";
	}

}
