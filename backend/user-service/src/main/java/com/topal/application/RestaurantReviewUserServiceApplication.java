package com.topal.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestaurantReviewUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantReviewUserServiceApplication.class, args);
	}

}
