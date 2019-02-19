package com.boh.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude= {
		org.activiti.spring.boot.SecurityAutoConfiguration.class
})
public class BohA6Application {

	public static void main(String[] args) {
		SpringApplication.run(BohA6Application.class, args);
	}

}
