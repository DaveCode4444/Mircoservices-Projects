package com.metamagic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class TokenServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokenServiceApplication.class, args);
	}
}
