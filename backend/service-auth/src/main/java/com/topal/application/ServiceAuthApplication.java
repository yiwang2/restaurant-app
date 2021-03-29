package com.topal.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceAuthApplication {

    public static void main(String[] args) {
    	
        SpringApplication.run(ServiceAuthApplication.class, args);
    }
}

