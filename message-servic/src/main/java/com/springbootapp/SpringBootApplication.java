package com.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.boot.autoconfigure.SpringBootApplication
@ComponentScan(basePackages={"com.controller"})
public class SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}
}
